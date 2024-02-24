package com.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private LoginUserService loginUserService;
	
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	public FailureHandler failhandler() {
		return new FailureHandler();
	}
    
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf(AbstractHttpConfigurer::disable)

				.headers((headers) -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))

				.authorizeHttpRequests(auth -> {
					try {
						auth
							.requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
							.requestMatchers(new AntPathRequestMatcher("/js/**")).permitAll()
							.requestMatchers(new AntPathRequestMatcher("/fonts/**")).permitAll()
							.requestMatchers(new AntPathRequestMatcher("/images/**")).permitAll()
							.requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
							.requestMatchers(new AntPathRequestMatcher("/main/**")).authenticated()
							.anyRequest().permitAll();

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				).formLogin((formLogin) -> formLogin.loginPage("/login")
													.defaultSuccessUrl("/main", true)
													.usernameParameter("id")
													.passwordParameter("pw")
													.failureHandler(failhandler())
													)
				
				.logout((logout) -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
										  .invalidateHttpSession(true)
										  .logoutSuccessUrl("/login"))
				
				.exceptionHandling((exception) -> exception.accessDeniedPage("/accessdenied"));
				
		http.userDetailsService(loginUserService);

		return http.build();
	}
	
}
