package pl.javastart.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> builder = auth.jdbcAuthentication();
        builder.dataSource(dataSource);
        JdbcUserDetailsManager userDetailsService = builder.getUserDetailsService();
        userDetailsService.setUsersByUsernameQuery("select username,password,enabled from accounts where username = ?");
        userDetailsService.setAuthoritiesByUsernameQuery("select username,authority from roles where username = ?");
        userDetailsService.setCreateUserSql("insert into accounts (username, password, enabled) values (?,?,?)");
        userDetailsService.setCreateAuthoritySql("insert into roles (username, authority) values (?,?)");
        //      builder.withDefaultSchema() //tylko dla bazy HSQLDB
        builder.withUser("admin").password("AdMin!@3").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
            .antMatchers("/").permitAll()
            .anyRequest().authenticated()
        .and()
        .formLogin();
    }
    
}
