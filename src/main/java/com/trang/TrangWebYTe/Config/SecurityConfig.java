package com.trang.TrangWebYTe.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.trang.TrangWebYTe.TrangWebYTeApplication;
import com.trang.TrangWebYTe.Service.CustomerService;

@Configurable
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	CustomerService customerUserDetailService;
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**").anyRequest();
		web.ignoring().antMatchers("/css/**","/fonts/**","/js/**","/scss/**","/images/**","/assets/**","/fontawesome/**","/assetsAdmin/**");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 // Trang chỉ dành cho Bacsi
//		http.authorizeRequests().antMatchers("/homebacsi/**").access("hasRole('ROLE_USER')");
		http.authorizeRequests().antMatchers("/bacsi/**","/selectKhoa**","/home/**","/homeImportant/**","/register/**").permitAll().antMatchers("/homebacsi/**","/lichdakham/**","/thongke/**","/dangkilich/**","/accountbacsi/**").hasRole("BACSI").antMatchers("/homeadmin/**","/accountadmin/**","/dslichkham/**","/dsbacsiadmin","/dsbenhnhanadmin","/dsthuocadmin/**","/dsadmin/**","/themadmin/**").hasRole("ADMIN").anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().defaultSuccessUrl("/homeImportant").failureUrl("/login?success=flase")
				.loginProcessingUrl("/j_spring_security_check").and().logout().permitAll();
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customerUserDetailService).passwordEncoder(passwordEncoder());
		System.out.println(auth.userDetailsService(customerUserDetailService).passwordEncoder(passwordEncoder()));
	}
}
