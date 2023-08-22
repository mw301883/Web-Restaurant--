package pl.michalwieczorek.restaurantservice.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        RequestMatcher adminRequestMatcher = new AntPathRequestMatcher("/admin/**");
        RequestMatcher dbRequestMatcher = new AntPathRequestMatcher("/h2-console/**");
        http
            .authorizeRequests(authorizeRequests ->
                    authorizeRequests
                            .requestMatchers(adminRequestMatcher).hasRole("ADMIN")
                            .anyRequest().permitAll()
            )
            .httpBasic(withDefaults());
        http
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login")
            .addLogoutHandler((request, response, auth) -> {
                    SecurityContextHolder.clearContext();
                });
//        http
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers(dbRequestMatcher).permitAll()
//                                .anyRequest().authenticated()
//                )
//                .headers().frameOptions().disable()
//                .and()
//                .httpBasic(withDefaults());

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}password")
                .roles("ADMIN");
    }
}



