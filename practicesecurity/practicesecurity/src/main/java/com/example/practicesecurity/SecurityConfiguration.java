package com.example.practicesecurity;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
	public class SecurityConfiguration extends WebSecurityConfigurerAdapter {




	// @Autowired
	// private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	PasswordEncoder encoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();




	// INMEMORY
	auth.inMemoryAuthentication()
	.withUser("swathi")
	.password(encoder.encode("1234"))
	.roles("USER")
	.and()
	.withUser("namu")
	.password(encoder.encode("2345"))
	.roles("ADMIN");



	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	http.authorizeRequests()
	.antMatchers("/hello/").permitAll()
	.antMatchers("/hello/admin").hasRole("ADMIN")
	.antMatchers("/hello/user").hasAnyRole("USER","ADMIN")
	//
	.and().formLogin();
	}

	}

