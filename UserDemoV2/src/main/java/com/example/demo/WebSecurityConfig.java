package com.example.demo;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	  private DataSource dataSource;
	
	/*@Autowired
	private UserDetailsService userDetailsService;*/
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}*/
	
	
	
	@Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	    auth.jdbcAuthentication().dataSource(dataSource)
	        .usersByUsernameQuery("select username, password, true from user where username=?")
	        
	        .authoritiesByUsernameQuery("select distinct T1.username,T5.menu_url from user T1 inner join user_role_mapping T2 on T1.id = T2.user_id " + 
	        		"inner join role T3 on T2.role_id = T3.id inner join role_menu_mapping T4 " + 
	        		"on T3.id = T4.role_id inner join menu T5 on T4.menu_id = T5.id where T1.username=?")
	        .passwordEncoder(NoOpPasswordEncoder.getInstance());
	        		//.passwordEncoder(new BCryptPasswordEncoder());
	        //.passwordEncoder(new BCryptPasswordEncoder());
	  }
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/userCration").access("hasAuthority('userCration')")   /*hasRole('recruitment')*/
		.antMatchers("/revenue").access("hasAuthority('revenue')")
		.antMatchers("/saving").access("hasAuthority('saving')")
		.antMatchers("/editUser").access("hasAuthority('editUser')")
		.anyRequest().permitAll()
		.and()
		.formLogin().loginPage("/login")
		.defaultSuccessUrl("/dashboard", true)
		.failureUrl("/login?denied")
		.usernameParameter("username").passwordParameter("password")
		.and()
		.logout().logoutSuccessUrl("/login?logout") 
		.and()
		.exceptionHandling().accessDeniedPage("/login?denied")
		.and().csrf().disable();
		
	}
	
	/*@Bean(name="passwordEncoder")
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}*/

	
	
	public static void main(String[] args) {
		String password = new BCryptPasswordEncoder().encode("admin123");
		
		System.out.println(password);
	}

}
