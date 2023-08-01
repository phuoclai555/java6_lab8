package com.nhom1.java6.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig{

//  Khi nào thêm client mới có thể dễ dàng chỉnh sửa code

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
         http
                 .formLogin(form -> form
                 .loginPage("/security/login/form")
                 .loginProcessingUrl("/security/login")
                 .defaultSuccessUrl("/security/login/success",false)
                 .failureForwardUrl("/security/login/error")
                 .usernameParameter("username")
                 .passwordParameter("password"))
                .httpBasic(Customizer.withDefaults())
                 .csrf(config -> config.disable())
                 .cors(config -> config.disable())
                 .authorizeHttpRequests(req -> req
                         .requestMatchers("/order/**").authenticated()
                         .requestMatchers("/assets/admin/**").hasAnyAuthority("STAF","DIRE")
                         .requestMatchers("/rest/**").hasAuthority("STAF")
                         .anyRequest().permitAll())
                 .rememberMe(remb -> remb.tokenValiditySeconds(86400))
                 .logout(logout -> logout
                         .logoutUrl("/security/logoff")
                         .logoutSuccessUrl("/security/login/success"))
                .exceptionHandling(excep -> excep.accessDeniedPage("/security/unauthoried"));
        return http.build();
    }



}
