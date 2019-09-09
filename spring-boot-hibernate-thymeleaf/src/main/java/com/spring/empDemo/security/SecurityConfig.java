package com.howtodoinjava.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
		System.err.println(new Object() {
		}.getClass().getEnclosingMethod().getName() + " method called !!!");
		authBuilder.inMemoryAuthentication().withUser("root").password("{noop}root").roles("USER");
				/*.passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
				.withUser("prit").password("prit").roles("prit").and().withUser("narola").password("narola")
				.roles("narola", "narola");*/
	}

	protected void configure(HttpSecurity http) throws Exception {
		System.err.println(new Object() {
		}.getClass().getEnclosingMethod().getName() + " method called !!!");
		
		 http
         .csrf().disable()
         .authorizeRequests().anyRequest().authenticated()
         .and()
         .httpBasic();
		
		/*
		 * http.httpBasic().and().authorizeRequests().antMatchers("/employee/**").
		 * hasRole("prit").antMatchers("/**")
		 * .hasRole("narola").and().csrf().disable().headers().frameOptions().disable();
		 */
	}
}
