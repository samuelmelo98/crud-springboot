package br.com.string.string_back_end.config;

import br.com.string.string_back_end.security.CustomUserDetailsService;
import br.com.string.string_back_end.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
/***
 * Classe de configuração de segurança
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            return http
                    .csrf(AbstractHttpConfigurer::disable)// para habilitar request de outras api
                    .httpBasic(Customizer.withDefaults())//habilita http basic para api's
                   .formLogin(configurer -> {
                       configurer.loginPage("/login").permitAll();
                   })//habilitar form padrão do spring
                    .authorizeHttpRequests(authorize ->{
                            authorize.requestMatchers("/login/**").permitAll();
                            authorize.requestMatchers(HttpMethod.POST, "users/**").permitAll();
                            authorize.anyRequest().authenticated();
                    })
                    .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public UserDetailsService userDetailsService(UserService userService){

        return new CustomUserDetailsService(userService);
    }
}
