package br.com.loja.siteware.security.admin;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@Order(2)
public class SecurityAdmin extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("siteware")
                .password(new BCryptPasswordEncoder().encode("siteware")).roles("ADMIN",
                        "USER")
                .authorities("gerente", "vendedor");

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select email as username, senha as password, 1 as enable from funcionario where email=?")
                .authoritiesByUsernameQuery(
                        "select funcionario.email as username, papel.nome as authority from permissoes inner join funcionario on funcionario.id=permissoes.funcionario_id inner join papel on permissoes.papel_id=papel.id where funcionario.email=?")
                .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/admin/entrada/**").hasAuthority("gerente")
                .antMatchers("/admin/**").hasAnyAuthority("gerente", "vendedor")
                .and()
                .formLogin()
                .loginPage("/login").permitAll().and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/admin").and()
                .exceptionHandling().accessDeniedPage("/negadoAdministrativo");

    }

}
