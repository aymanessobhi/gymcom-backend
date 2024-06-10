package com.ideracloud.gymcom.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Resource(name = "userService")
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UnauthorizedEntryPoint unauthorizedEntryPoint;

    private AuthenticationConfiguration Ac =new AuthenticationConfiguration();


    @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        AuthenticationManager authenticationManager =  authenticationManager(Ac);
        http.cors(Customizer.withDefaults()).csrf(AbstractHttpConfigurer::disable).
                authorizeHttpRequests((authz)->authz.requestMatchers("/auth/**","/inscription/**","/data/**").permitAll().anyRequest().authenticated())
                .authenticationManager(authenticationManager)
                .addFilterBefore(authenticationTokenFilterBean(),UsernamePasswordAuthenticationFilter.class).exceptionHandling((handle)->handle.authenticationEntryPoint(unauthorizedEntryPoint))
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


}
