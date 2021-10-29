package com.ciircat.studentsupport.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder);

        return authProvider;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    /*
     * Tato metoda se stará o autorizaci, říká že na url začínající /admin pustí jen ty uživatele,
     * kteří mají roli ADMIN, na url začínající /user pustí uživatele, kteřá mají buď roli ADMIN nebo
     * USER a na url zařínající na / pustí všechny
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user/*").hasAnyRole("ADMIN","USER")
                .antMatchers("/").permitAll()
                .and().formLogin().loginPage("/login").permitAll().successForwardUrl("/user/homepage").failureUrl("/loginfailed")
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true).invalidateHttpSession(true).logoutSuccessUrl("/login")
        ;
    }
}
