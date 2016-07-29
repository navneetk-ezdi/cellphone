package com.ezdi.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static com.ezdi.constant.CellphoneConstant.*;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication()
			.withUser("navneet")
			.password("nvnt8891")
			.authorities(ROLE_ADMIN);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(SLASH + HOME).access(HAS_ROLE_ADMIN)
			.antMatchers(SLASH + VIEW + SLASH + D_STAR).access(HAS_ROLE_ADMIN)
			.antMatchers(SLASH + INSERT + SLASH + D_STAR).access(HAS_ROLE_ADMIN)
			.antMatchers(SLASH + DELETE + SLASH + D_STAR).access(HAS_ROLE_ADMIN)
			.and()
				.formLogin().loginPage(SLASH + LOGIN)
				.defaultSuccessUrl(SLASH + HOME,true)
				.failureUrl(SLASH + DENIED)
				.usernameParameter(USERNAME).passwordParameter(PASSWORD)				
			.and()
				.logout().logoutSuccessUrl(SLASH + LOGOUT)
				.and().csrf().disable()
		        .exceptionHandling().accessDeniedPage(SLASH + DENIED); 
		
	}
}