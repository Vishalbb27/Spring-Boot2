package com.example.MycoolApp.springDataSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    //add support for JDBC ... no more hardcoded users :-)
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        //define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username, password, enabled from users where username=?"
        );
        //define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select username, authority from authorities where username = ?"
        );
        return jdbcUserDetailsManager;
    
    }

    /*@Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test1234")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test12345")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john,mary,susan);
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/magic-api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/magic-api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/magic-api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/magic-api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/magic-api/employees/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/thymeleaf/hello").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/showForm").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/processForm/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/customer/post").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/customer").hasRole("EMPLOYEE")
        );

        //user HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable Cross site Request Forgery (CSRF)
        //in general, not required for stateless REST APIs that use POST,PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
