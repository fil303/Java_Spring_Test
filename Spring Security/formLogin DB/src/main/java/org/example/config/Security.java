package org.example.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "org.example")
public class Security extends WebSecurityConfigurerAdapter {
    private static BCryptPasswordEncoder passwordEncorder = new BCryptPasswordEncoder();
    @Autowired
    DataSource dataSource;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//
//                .withUser("user").password("{noop}password").roles("USER");
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enable from users where username = ?")
//                .authoritiesByUsernameQuery("select u1.username,  u2.role from User u1 , Roles u2 where u1.roleId=u2.user_role_id and u1.username = ?");
                .authoritiesByUsernameQuery("select username, password, enable from users where username = ?")
                .passwordEncoder(passwordEncorder);
    }

    public String bcryptEncryptor(String plainText) {
        return passwordEncorder.encode(plainText);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeRequests()
                .antMatchers("/home")
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/failed")
                .permitAll();
                ;
        System.out.println("Security Working....");

    }

//    @Bean
//    public CustomFilter customFilter() {
//        return new CustomFilter();
//    }
}
