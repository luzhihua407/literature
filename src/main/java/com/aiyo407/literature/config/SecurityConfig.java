///*
// * Copyright 2012-2019 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//package com.ktu56.uaa.config;
//
//import com.ktu56.uaa.service.impl.UserDetailsServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.util.DigestUtils;
//
///**
// * @author Joe Grandja
// */
//@EnableWebSecurity
//@Order(99)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	public void configure(WebSecurity web) {
//		web
//			.ignoring()
//				.antMatchers("/webjars/**");
//
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
////		http
////			.authorizeRequests().mvcMatchers("/token").hasAuthority("admin")
////				.anyRequest().authenticated()
////				.and().formLogin().loginPage("https://localhost:8443/cas/login");
//		http
//				.csrf(csrf -> csrf.disable());
//		http.cors().disable();
////        http.formLogin().disable();
////				.loginPage("/login")
////				.failureUrl("/login-error")
////				.permitAll()
////				.and()
////			.oauth2Client();
//
//	}
//
//    @Bean
//	UserDetailsServiceImpl customUserDetailsService() {
//        return new UserDetailsServiceImpl();
//    }
//
//    @Bean
//	public AuthenticationProvider authenticationProvider(){
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setUserDetailsService(customUserDetailsService());
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//		return daoAuthenticationProvider;
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder(){
//		return new MD5PasswordEncoder();
//	}
//}
//class MD5PasswordEncoder implements PasswordEncoder {
//
//	@Override
//	public String encode(CharSequence charSequence) {
//
//		return null;
//	}
//
//	@Override
//	public boolean matches(CharSequence charSequence, String s) {
//		String psw = DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
//		if(psw.equals(s)){
//			return true;
//		}
//
//		return false;
//	}
//}
