package br.com.bycoffe.flowes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
    public class SecurityConfig {

    @Autowired
    private AuthorizationFilter authFilter;

    @Autowired
    Environment env;

    @Bean
    public SecurityFilterChain filterChainHandler(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
            .requestMatchers(HttpMethod.POST, "/api/v1/auth", "/api/v1/client").permitAll()
            .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
            .and()
            .csrf().disable()
            .formLogin().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .headers().frameOptions().sameOrigin()
            .and()
            .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        if (env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("open")) {
            http
                .authorizeHttpRequests()
                .anyRequest().permitAll();
        } else {
            http
                .authorizeHttpRequests()
                .anyRequest().authenticated();
        }

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoderHandler() {
        return new BCryptPasswordEncoder();
    }

}
