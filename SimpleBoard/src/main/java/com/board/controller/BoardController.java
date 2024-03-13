package com.board.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

		// 페이징
		int pageCount = 10; // 한 페이지에 보일 글 갯수
		int boardCount = service.boardCount();
		int startBoardNumber = (page - 1) * pageCount; // 글 시작 인덱스
		m.addAttribute("start", startBoardNumber + 1);

		int pageSelect = 5; // 선택 할 수 있는 페이지 수
		int totalPages = boardCount / pageCount + (boardCount % pageCount > 0 ? 1 : 0); // 전체 페이지 수

		int startPageNumber = (page - 1) / pageSelect * pageSelect + 1; // 페이징 시작 번호

		int endPageNumber = startPageNumber + pageSelect - 1; // 페이징 끝 번호

		if (endPageNumber > totalPages) {
			endPageNumber = totalPages;
		}

		m.addAttribute("pageSelect", pageSelect);
		m.addAttribute("startPageNumber", startPageNumber);
		m.addAttribute("endPageNumber", endPageNumber);
		m.addAttribute("totalPages", totalPages);

		m.addAttribute("board", service.selectList(startBoardNumber, pageCount));
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
	public String write(@RequestParam(value = "userid") String userId, Model m,
			@RequestParam(value = "content") String content, BoardDto dto) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		dto.setUserid(userId);
		dto.setBoardviews(0);
		dto.setBoardwritedate(format.format(now));
		dto.setBoarddtail(content);
		service.writeBoard(dto);
		return "redirect:freeboard";
	}

	// 이미지 업로드
	@PostMapping("/imgupload")
	public void fileUpload(BoardDto board, MultipartFile file) throws IllegalStateException, IOException {
		// 파일 업로드 처리 시작
        String projectPath = System.getProperty("user.dir") // 프로젝트 경로를 가져옴
                + "\\src\\main\\resources\\static\\files"; // 파일이 저장될 폴더의 경로

        UUID uuid = UUID.randomUUID(); // 랜덤으로 식별자를 생성

        String fileName = uuid + "_" + file.getOriginalFilename(); // UUID와 파일이름을 포함된 파일 이름으로 저장

        File saveFile = new File(projectPath, fileName); // projectPath는 위에서 작성한 경로, name은 전달받을 이름

        file.transferTo(saveFile);

        board.setFilename(fileName);
        
        board.setFilepath("/files/" + fileName); // static 아래부분의 파일 경로로만으로도 접근이 가능
        // 파일 업로드 처리 끝

//      BoardService.save(board); // board를 저장소에 save
        System.out.println("테스트");
    }
	
	// 파일 업로드
	@PostMapping("/fileupload")
	public String submitReport1(@RequestParam(value = "file") MultipartFile report) {
		printInfo(report);
		System.out.println(upload(report));
		return "redirect:freeboard";
	}

	// c:/upload폴더 생성
	private String upload(MultipartFile tempfile) {
		String fileName = makeName(tempfile.getOriginalFilename());

		File newFile = new File("c:/upload/" + fileName);

		try {
			tempfile.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return newFile.getPath();
	}

	private String makeName(String oName) {
		long currentTime = System.currentTimeMillis();
		Random random = new Random();
		int r = random.nextInt(50);// 0 ~ 49
		int index = oName.lastIndexOf(".");
		String ext = oName.substring(index + 1);

		return currentTime + "_" + r + "." + ext;
	}

	private void printInfo(MultipartFile report) {
		System.out.println("업로드 한 파일: " + report.getOriginalFilename());
	}

//	//webapp/mainImg폴더 생성
//	@RequestMapping(value = "/report/submitReport2", method = RequestMethod.POST)
//	public String submitReport2(MultipartHttpServletRequest request, Model m) {
//		String studentNumber = request.getParameter("studentNumber");
//		MultipartFile report = request.getFile("report");
//		printInfo(studentNumber, report);
//		String path = request.getServletContext().getRealPath("/mainImg");
//		// 서버상의 application 경로 + /mainImg
//		try {
//			report.transferTo(new File(path + "/" + report.getOriginalFilename()));
//		} catch (IllegalStateException | IOException e) {
//			e.printStackTrace();
//		}
//		m.addAttribute("path", report.getOriginalFilename());
//		return "report/submissionComplete";
//	}
//	// resources/static/upload폴더 생성
//	@RequestMapping(value = "/report/submitReport3", method = RequestMethod.POST)
//	public String submitReport3(ReportCommand reportCommand, Model m) {
//
//		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
//		try {
//			String path = ResourceUtils.getFile("classpath:static/upload/").toPath().toString();
//			System.out.println(path);
//			reportCommand.getReport().transferTo(new File(path, reportCommand.getReport().getOriginalFilename()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		m.addAttribute("path", reportCommand.getReport().getOriginalFilename());
//		return "report/submissionComplete";
//	}
//}
	
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
	public String freeboardDelete(@AuthenticationPrincipal SecurityUser user,
			@RequestParam(value = "boardnumber") String boardnumber) {
		LoginDto userinfo = user.getUsers();
		String id = userinfo.getUserId();
		Map<String, Object> boardInfo = new HashMap<>();
		boardInfo.put("userid", id);
		boardInfo.put("boardnumber", boardnumber);
		service.deleteBoard(boardInfo);
		return "redirect:freeboard";
	}

	// 제목 + 내용 검색
	@GetMapping("/search")
	public String searchTitleAndDetail(@RequestParam(value = "search") String search,
			@RequestParam(value = "order") String searchType, Model m) {
		Map<String, Object> searching = new HashMap<>();
		if (searchType.equals("titleanddetail")) {
			System.out.println("titleanddetail");
			searching.put("boardtitle", search);
			searching.put("boarddtail", search);
			m.addAttribute("result", service.searchTitleAndDetail(searching));
		} else if (searchType.equals("writer")) {
			searching.put("userid", search);
			m.addAttribute("result", service.searchWriter(searching));
		}

		return "freeboard/freeboardsearch";
	}

}
