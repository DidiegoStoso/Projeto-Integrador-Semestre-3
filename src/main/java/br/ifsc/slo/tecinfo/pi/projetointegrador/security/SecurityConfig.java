package br.ifsc.slo.tecinfo.pi.projetointegrador.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ImplementsUserDetailsService uds;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/", "/itens/mostrar","/garcom/cadastrar").permitAll() 
                //.antMatchers("/*/cadastrar").access("hasRole('USER')") //exemplo para permitir acesso a uma pagina apenas para quem tem role USER (apenas exemplo)
                //.antMatchers("/*/add").access("hasRole('USER')")
                .anyRequest().authenticated()
                //.and()
                //.exceptionHandling().accessDeniedPage("/403")
                .and()
                .formLogin() 
                .loginPage("/login")
                .defaultSuccessUrl("/itens/mostrar", true)
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
        throws Exception{
        auth.userDetailsService(uds)
        .passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
