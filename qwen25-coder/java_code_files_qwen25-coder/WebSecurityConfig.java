import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/data/**").authenticated() // Require authentication for /data endpoints
                .anyRequest().permitAll()                // Allow access to other endpoints without authentication
                .and()
            .httpBasic();                                // Use HTTP Basic Authentication
    }

    public static void main(String[] args) {
    }
}