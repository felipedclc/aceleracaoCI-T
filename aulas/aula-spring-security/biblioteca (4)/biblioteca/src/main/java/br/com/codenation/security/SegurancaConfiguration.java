package br.com.codenation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableWebSecurity // habilita os recursos de segurança em nossa aplicação.
@EnableAuthorizationServer // auth do user
@EnableResourceServer // api que estamos criando
public class SegurancaConfiguration extends WebSecurityConfigurerAdapter {
    // WebSecurityConfigurerAdapter - herda comportamentos do spring security

    @Autowired
    private UserDetailsService userService; // service do spring

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception { // ignorando padrões do swagger
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui", // urls que não vão passar pelo filtro do spring security
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // provendo a maneira de autenticar
        // spring verifica se existe o usuário e se está correta a senha para validação
        auth.userDetailsService(this.userService)
                .passwordEncoder(passwordEncoder()); // criptografa a senha
    }

    @Bean
    public PasswordEncoder passwordEncoder() { // apenas para testes
        return NoOpPasswordEncoder.getInstance();
    }

}
