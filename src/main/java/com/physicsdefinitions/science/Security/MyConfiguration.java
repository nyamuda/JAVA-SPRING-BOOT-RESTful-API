package com.physicsdefinitions.science.Security;

import java.util.List;

import com.physicsdefinitions.science.Services.UserDetailsImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
public class MyConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsImplementation userDetails;

    // public MyConfiguration(BCryptPasswordEncoder passwordEncoder,
    // UserDetailsImplementation userDetails) {
    // this.passwordEncoder = passwordEncoder;
    // this.userDetails = userDetails;
    // }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // telling the authenticationManger how the user user should be authenticated
        auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll()
                // ADMIN ROUTES
                .antMatchers("/curriculum/save").hasAuthority("ADMIN").antMatchers("/subject/save")
                .hasAuthority("ADMIN").antMatchers("/topic/save").hasAuthority("ADMIN")
                .antMatchers("/topic/add_curriculum").hasAuthority("ADMIN").antMatchers("/term/save")
                .hasAuthority("ADMIN").antMatchers("term/add_curriculum").hasAuthority("ADMIN")
                .antMatchers("definition/save").hasAuthority("ADMIN").antMatchers("/role/save").hasAuthority("ADMIN")
                .antMatchers("/user/add_role").hasAuthority("ADMIN").antMatchers("/users").hasAuthority("ADMIN")
                .antMatchers("/roles").hasAuthority("ADMIN")
                // USER ROUTES
                .antMatchers("/curriculum**").hasAuthority("USER").antMatchers("/subject**").hasAuthority("USER")
                .antMatchers("term**").hasAuthority("USER").antMatchers("/definition**").hasAuthority("USER")
                .antMatchers("user/{username}").hasAuthority("USER").antMatchers("/user/save").permitAll()
                .antMatchers("/").permitAll();

        http.csrf().disable();
        http.formLogin().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        // ENABLING CORS FOR ALL REQUESTS
        http.cors().configurationSource(request -> {
            CorsConfiguration cors = new CorsConfiguration();
            cors.setAllowedOrigins(List.of("*"));
            cors.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(List.of("*"));
            return cors;
        });
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
