package com.lib.springbootrestapirestauth.config;

import com.lib.springbootrestapirestauth.filter.JWTAuthenticationFilter;
import com.lib.springbootrestapirestauth.filter.JWTAuthorizationFilter;
import com.lib.springbootrestapirestauth.service.AuthenticationUserDetailService;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.RequiredArgsConstructor;

/*
--  This Class
-   Introduce all the components we developed for our security configuration
-   http.cors().and().csrf().disable() – This will disable CSRF protection and Cross origin from our API.
-   .antMatchers(HttpMethod.POST, AuthenticationConfigConstants.SIGN_UP_URL).permitAll() – With this I’m allowing to access our user register API endpoint without authentication.
-   .anyRequest().authenticated() – This will authenticate every and each request coming to our API.
-   .addFilter(new JWTAuthenticationFilter(authenticationManager())) – Introducing authentication filter.
-   .addFilter(new JWTAuthorizationFilter(authenticationManager()))– Introducing authorization filter.
-   .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) – Setting session creation policy to STATELESS.
-   auth.userDetailsService(authenticationUserDetailService).passwordEncoder(bCryptPasswordEncoder); – Here we are setting our user details service implementation with password encoder.
 */

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationUserDetailService authenticationUserDetailService;

    @Override protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, AuthenticationConfigConstants.SIGN_UP_URL).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }
}