import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// Example OAuth 2.0 setup in Spring Security (Java)
@EnableWebSecurity
public class SecurityConfig_3 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .oauth2Login();
    }

    public static void main(String[] args) {
    }

}