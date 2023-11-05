package com.samsclub.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration    // Comment this out for testing RestController
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    // We will create userService class in upcoming step
    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests()
                .antMatchers(
                        "/registration**",
                        "/js/**",
                        "/css/**",
                        "/images/**",
                        "/webjars/**", "/api/**").permitAll()
                .antMatchers("/login", "/signup", "/",
                        "/cover","/item","/supplier","/purchaseOrder","/store","/category").permitAll()
                .antMatchers("/users", "/deleteUser/**", "/saveUser/**", "/showFormForUpdate/**","/item", "/my_items", "/my_items/**",
                        "/saveItem", "/deleteItem/**","/deleteSupplier/**","/deleteStore/**","/deleteCategory/**")
                .hasAnyRole("ADMIN")
                .antMatchers(   "/my_purchaseOrders", "/my_purchaseOrders/**",
                        "/savePurchaseOrder", "/deletePurchaseOrder/**")
                .hasAnyRole("ADMIN", "MANAGER")


                .antMatchers("/**").hasAnyRole("STAFF", "ADMIN", "MANAGER")

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/cover", true)
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
        // @formatter:on
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}

