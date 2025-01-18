import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DatabaseUserDetailService databaseUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
            .userSearchFilter("(&(uid={0})(simpleAuthTag=*))") // Adjust this to your actual LDAP search filter query.
            .contextSource().url("<YourLDAPserverURL>" + "/" + "<BaseDN>") // Replace with your LDAP server URL and suitable base DN where you look up LDAP users.
                .and()
            .userDetailsService(databaseUserDetailService)
                .passwordCompare(); // This is mandatory to allow comparison of password received from LDAP to be matched against UserDetailsPassword in the configured UserDetails object.
    }
}