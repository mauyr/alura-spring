package br.com.caelum.loja.conf;

import br.com.caelum.loja.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by mauyr on 10/02/17.
 */
@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Autowired
//    public UsuarioDAO usuarioDAO;

    @Bean
    public CsrfTokenRepository csrfTokenRepository() {
        return CookieCsrfTokenRepository.withHttpOnlyFalse();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        TODO: Corrigir spring security após realizar refactors do template a adicionar paths do actuator como permit
//        http.authorizeRequests()
//                .antMatchers("/produtos/edit").hasRole("ADMIN")
//                .antMatchers("/carrinho/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/produtos").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/produtos").hasRole("ADMIN")
//                .antMatchers("/produtos/**").permitAll()
//                .antMatchers("/payment/**").permitAll()
//                .antMatchers("/").permitAll()
//                .antMatchers("/webjars/**").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin().loginPage("/login").permitAll()
//                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        http.authorizeRequests().antMatchers("**").permitAll();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//        auth.userDetailsService(usuarioDAO);
    }
}
