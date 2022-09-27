package br.com.iprsaojose.iprsys.configuration;

import javax.sql.DataSource;

import org.aspectj.weaver.bcel.BcelAccessForInlineMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        //UserDetails user =
        //        User.builder()
        //            .username("user")
        //            .password(encoder.encode("test123"))
        //            .roles("ADMIN")
        //            .build();

        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .passwordEncoder(encoder);
            //.withUser(user);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/index").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/api/**").permitAll()
            .antMatchers("/sistema/**")//.hasAuthority("ADMIN")//.anyRequest()
            .authenticated().and().csrf().disable().formLogin()
            .loginPage("/login").failureUrl("/index-error")
            .defaultSuccessUrl("/sistema/home", true)
            .usernameParameter("username")
            .passwordParameter("password");
            //.and().logout(logout -> logout.logoutUrl("/logout"))
            // .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            // .logoutSuccessUrl("/index").and().exceptionHandling()
            // .accessDeniedPage("/access-denied");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/imagens/**");
    }

}
