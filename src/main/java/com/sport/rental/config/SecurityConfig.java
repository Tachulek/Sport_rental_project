package com.sport.rental.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf()
				.disable()
				.authorizeRequests()
				.anyRequest().permitAll()
				.and()
				.addFilterBefore(new CustomFilter(), BasicAuthenticationFilter.class)
				.httpBasic();
	}

	//    @Bean
	//    public PasswordEncoder passwordEncoder() {
	//        return new BCryptPasswordEncoder();
	//    }
}
