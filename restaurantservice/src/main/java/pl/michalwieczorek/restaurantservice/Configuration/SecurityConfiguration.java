package pl.michalwieczorek.restaurantservice.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import pl.michalwieczorek.restaurantservice.Service.AdminAccountService;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final AdminAccountService adminAccountService;
    private DataSource dataSource;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public SecurityConfiguration(AdminAccountService adminAccountService, DataSource dataSource, PasswordEncoder passwordEncoder){
        this.adminAccountService = adminAccountService;
        this.dataSource = dataSource;
        this.passwordEncoder = passwordEncoder;
    }
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        RequestMatcher adminRequestMatcher = new AntPathRequestMatcher("/admin/**");
        RequestMatcher dbRequestMatcher = new AntPathRequestMatcher("/h2-console/**");
        http.formLogin(withDefaults());
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(adminRequestMatcher).hasRole("ADMIN")
                                .requestMatchers(dbRequestMatcher).permitAll()
                                .anyRequest().permitAll()
                )
                .httpBasic(withDefaults());
        http
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and()
                .csrf().disable()
                .headers().frameOptions().disable();
        return http.build();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT USERNAME, PASSWORD, 'true' as ENABLED FROM ADMIN_ACCOUNT WHERE USERNAME=?")
                .authoritiesByUsernameQuery("SELECT USERNAME, 'ROLE_ADMIN' as AUTHORITY FROM ADMIN_ACCOUNT WHERE USERNAME=?")
                .passwordEncoder(passwordEncoder);
    }
}



