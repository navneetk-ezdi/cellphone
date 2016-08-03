package com.ezdi.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static com.ezdi.constant.CellphoneConstant.*;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	 DataSource dataSource;
	  
	 @Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	   
	   auth.jdbcAuthentication().dataSource(dataSource)
	  .usersByUsernameQuery(
	   "select username,password, enabled from users where username=?")
	  .authoritiesByUsernameQuery(
	   "select username, role from user_roles where username=?");
	 } 
	 
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication()
			.withUser("navneet")
			.password("nvnt8891")
			.authorities(ROLE_ADMIN);
	}*/
	
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
				.and().logout().disable()
				.csrf().disable()
		        .exceptionHandling().accessDeniedPage(SLASH + DENIED)
		        
		    .and()
		    	.sessionManagement()
		    		.maximumSessions(1)
		    		.expiredUrl(SLASH + EXPIRED); 
		
	}
}