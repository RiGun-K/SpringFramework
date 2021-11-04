package com.example.mylist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.example.mylist.service.UserDetailsServiceImpl; 

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetails;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// 인증하지 않을 주소 추가
		web.ignoring().antMatchers("/css/**", "/js/**", "/image/**");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
		// 비밀번호 input 값에 "1111" 로 설정 
		System.out.println(passwordEncoder().encode("1111"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				// mypoint/** 페이지는 admin, user 만 접속허용
				.antMatchers("/mypoint/**").hasAnyRole("admin", "user")
				// adduser, update/** 페이지는 admin 만 접속허용
				.antMatchers("/adduser/**", "/update/**").hasRole("admin")
				// 모두허용
				.antMatchers("/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				// 로그인페이지는 /login 
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
				// 로그아웃 하면 "/" 로 이동
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				.and()
			.exceptionHandling()
				.accessDeniedPage("/denied")
				.and()
			.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}
}
