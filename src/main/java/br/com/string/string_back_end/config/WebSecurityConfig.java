//package br.com.string.string_back_end.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig implements WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable() // Desabilita o CSRF se necessário
//                .authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Permite OPTIONS para todos os endpoints
//                .anyRequest().authenticated(); // Requer autenticação para os outros métodos
//    }
//}
//
//
