//package mcjerz.udemy.spring.osiris.config;
//
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter
//{
//
//    @Bean
//    public PasswordEncoder passwordEncoder()
//    {
//        return new BCryptPasswordEncoder();
//    }
//
//
//
//        protected void configure(final AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER").and()
//                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER").and()
//                .withUser("admin1").password(passwordEncoder().encode("admin1Pass")).roles("ADMIN");
//    }
//
//
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception
//    {
//      http.authorizeRequests()
//              .antMatchers("/user/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
//              .and().httpBasic();
//    }
//
//
//}
