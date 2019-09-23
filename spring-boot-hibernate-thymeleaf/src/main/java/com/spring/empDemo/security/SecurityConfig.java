package com.spring.empDemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.empDemo.service.userDetailsServiceImpl;

 
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new userDetailsServiceImpl();
	}

	/*@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

	protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
//		System.err.println(new Object() {}.getClass().getEnclosingMethod().getName() + " method called !!!");

		authBuilder.inMemoryAuthentication().withUser("root").password("{noop}root").roles("USER");

//		authBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
		/*
		 * .passwordEncoder(org.springframework.security.crypto.password.
		 * NoOpPasswordEncoder.getInstance())
		 * .withUser("prit").password("prit").roles("prit").and().withUser("narola").
		 * password("narola") .roles("narola", "narola");
		 */
	}

	protected void configure(HttpSecurity http) throws Exception {
//		System.err.println(new Object() {}.getClass().getEnclosingMethod().getName() + " HttpSecurity method called !!!");

		http.csrf().disable().authorizeRequests().anyRequest().authenticated().antMatchers("employee/all**")
				.hasRole("admin").and().httpBasic().and().formLogin();
		

	}
}
