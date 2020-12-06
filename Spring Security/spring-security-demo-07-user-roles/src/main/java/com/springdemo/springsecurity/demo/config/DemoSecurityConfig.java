package com.springdemo.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// add our users for in memory authentication
		
		@SuppressWarnings("deprecation")
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
			.withUser(users.username("sena").password("9999").roles("EMPLOYEE"))
			.withUser(users.username("ayse").password("9999").roles("MANAGER","EMPLOYEE"))
			.withUser(users.username("tomris").password("9999").roles("ADMIN"));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception { // configure security login, logout

		http.authorizeRequests()			// restrict access based on the httpServletRequest	
			.anyRequest().authenticated()   // any request to the app must be authenticated
			.and()							
			.formLogin().loginPage("/showMyLoginPage")  // customize login - request mapping
			.loginProcessingUrl("/authenticateTheUser") // login form post data to this url for processing
			.permitAll() 								// everyone can see it
			.and().logout().permitAll();
	}

}
