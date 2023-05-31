package com.example.demo.config;

import com.example.demo.service.UserService;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return (e)-> {
            val userList = userService.findUserByAccount(e);
            if (userList == null || userList.isEmpty()) {
                throw new UsernameNotFoundException("User not found");
            }
            val user = userList.get(0);
            return new User(user.getAccount(), user.getPassword(), List.of(new SimpleGrantedAuthority("role")));
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login_action")
                .defaultSuccessUrl("/login_success")
                .failureUrl("/login_fail")
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/login", "/register", "/register_user", "/register_success")
                .permitAll()
                .requestMatchers( "/static/**","/resources/**", "/js/**", "/css/**", "/images/**", "/jquery/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable()
                .logout()
                .logoutUrl("/logout_action")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/logout")
                .and()
                .build();

//
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/register").permitAll()
//                                .requestMatchers("/register_user").permitAll()
//                                .requestMatchers("/registerSuccess").permitAll()
//                                .anyRequest().authenticated()
//                                )
//                .formLogin(formLogin ->
//                        formLogin
//                                .loginPage("/login")
//                                .permitAll())
//                .logout(LogoutConfigurer::permitAll);
//        return http.build();
    }


}
