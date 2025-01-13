import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// Server-side (Java)
// Using Spring Security and JWT
@Configuration
@EnableWebSecurity
public class SecurityConfig_163_163 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/secure-data").authenticated()
            .and()
            .oauth2Login();
    }

    public static void main(String[] args) {
    }
}