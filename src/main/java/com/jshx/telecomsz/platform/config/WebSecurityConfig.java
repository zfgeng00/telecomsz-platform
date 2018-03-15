package com.jshx.telecomsz.platform.config;

import com.jshx.telecomsz.platform.security.extend.CustomAuthenticationDetailsSource;
import com.jshx.telecomsz.platform.security.extend.SecurityAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created with Intellij IDEA by 王金 on 2017/2/20 下午2:31.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SecurityAuthenticationProvider securityAuthenticationProvider;

    private final CustomAuthenticationDetailsSource authenticationDetailsSource;

    @Autowired
    public WebSecurityConfig(SecurityAuthenticationProvider securityAuthenticationProvider,
                             CustomAuthenticationDetailsSource authenticationDetailsSource) {
        this.securityAuthenticationProvider = securityAuthenticationProvider;
        this.authenticationDetailsSource = authenticationDetailsSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**","/3d/**", "/img/**", "/fonts/**", "/i/**",
                        "/images/kaptcha.jpg", "/interface/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll().authenticationDetailsSource
                (authenticationDetailsSource).failureUrl("/login?error=true")
                .and().logout().permitAll()
                .and().sessionManagement().invalidSessionUrl("/login")
                .and().csrf().disable()
                .sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(false).expiredUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(securityAuthenticationProvider);
    }
}
