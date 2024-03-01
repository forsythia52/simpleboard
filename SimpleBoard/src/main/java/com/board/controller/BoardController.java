package com.board.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.config.SecurityUser;
import com.board.dto.BoardDto;
import com.board.dto.LoginDto;
import com.board.service.BoardService;
import com.board.service.CommentService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {

	@Autowired
	BoardService service;

	@Autowired
	CommentService commentService;

	// 자유 게시판 페이지
	@GetMapping("/freeboard")
	public String freeBoard(@AuthenticationPrincipal SecurityUser user, Model m,
			@RequestParam(name = "page", defaultValue = "1") int page) {
		LoginDto userInfo = user.getUsers();
		m.addAttribute("userInfo", userInfo);
		m.addAttribute("board", service.selectList(page));

		// 페이징
		int count = service.boardCount();
		if (count > 0) {

			int perPage = 10; // 한 페이지에 보일 글의 갯수
			int startRow = (page - 1) * perPage;

			List<BoardDto> boardList = service.selectList(startRow);
			m.addAttribute("start", startRow + 1);
			m.addAttribute("bList", boardList);

			int pageNum = 5;
			int totalPages = count / perPage + (count % perPage > 0 ? 1 : 0); // 전체 페이지 수

			int begin = (page - 1) / pageNum * pageNum + 1;
			int end = begin + pageNum - 1;
			if (end > totalPages) {
				end = totalPages;
			}
			m.addAttribute("begin", begin);
			m.addAttribute("end", end);
			m.addAttribute("pageNum", pageNum);
			m.addAttribute("totalPages", totalPages);
		}
		m.addAttribute("count", count);
		return "freeboard/freeboard";
	}

	// 게시글 작성 페이지
	@GetMapping("/boardwrite")
	public String boardWrite(@AuthenticationPrincipal SecurityUser user, Model m) {
		LoginDto userinfo = user.getUsers();
		String id = userinfo.getUserId();
		m.addAttribute("id", id);
		return "freeboard/freeboardwrite";
	}

	// 게시글 작성
	@PostMapping("/freeboardwrite")
	public String write(@RequestParam(value = "userid") String userId, BoardDto dto, Model m) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		dto.setUserid(userId);
		dto.setBoardviews(0);
		dto.setBoardwritedate(format.format(now));
		service.writeBoard(dto);
		return "redirect:freeboard";
	}

	// 게시글 상세 페이지
	@GetMapping("/freeboardview")
	public String view(HttpServletRequest request, Model m) {
		String boardnumber = request.getParameter("number");
		m.addAttribute("board", service.boardView(boardnumber));
		// 댓글 불러오기
		m.addAttribute("comment", commentService.commentList(boardnumber));
		// 게시글 조회수 +1
		service.boardCountUp(boardnumber);
		return "freeboard/freeboardview";
	}

	// 게시글 수정 페이지
	@GetMapping("freeboardupdate")
	public String freeboardUpdateView(HttpServletRequest request, Model m) {
		String boardnumber = request.getParameter("boardnumber");
		m.addAttribute("board", service.boardView(boardnumber));
		return "freeboard/freeboardupdate";
	}

	// 게시글 수정
	@PostMapping("/freeboardupdate")
	public String freeboardUpadte(@AuthenticationPrincipal SecurityUser user, BoardDto dto, Model m) {
		LoginDto userinfo = user.getUsers();
		String id = userinfo.getUserId();
		Map<String, Object> boardUpdate = new HashMap<>();
		boardUpdate.put("boardtitle", dto.getBoardtitle());
		boardUpdate.put("boarddtail", dto.getBoarddtail());
		boardUpdate.put("boardnumber", dto.getBoardnumber());
		boardUpdate.put("userid", id);
		service.updateBoard(boardUpdate);
		return "redirect:freeboard";
	}

	// 게시글 삭제
	@PostMapping("/freeboarddelete")
	public String freeboardDelete(@RequestParam(value = "boardnumber") String boardnumber) {
		service.deleteBoard(boardnumber);
		return "redirect:freeboard";
	}
}
