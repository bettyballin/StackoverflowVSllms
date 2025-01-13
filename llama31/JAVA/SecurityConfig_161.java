import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfig_161_161 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
            .userSearchBase("ou=people")
            .userSearchFilter("(uid={0})")
            .groupSearchBase("ou=groups")
            .groupSearchFilter("(member={0})")
            .ldapAuthoritiesPopulator(customLdapAuthoritiesPopulator())
            .contextSource()
            .url("ldap://localhost:10389/dc=example,dc=com")
            .managerDn("cn=admin,dc=example,dc=com")
            .managerPassword("password");
    }

    @Bean
    public CustomLdapAuthoritiesPopulator customLdapAuthoritiesPopulator() {
        return new CustomLdapAuthoritiesPopulator();
    }

    @Bean
    public JdbcUserDetailsService jdbcUserDetailsService() {
        return new JdbcUserDetailsService(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("myuser");
        dataSource.setPassword("mypassword");
        return dataSource;
    }
}

class CustomLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {
    @Override
    public Collection<? extends SimpleGrantedAuthority> getGrantedAuthorities(DirContextOperations user, String username) {
        // Use the jdbcUserDetailsService to retrieve the user's roles from the database
        JdbcUserDetailsService userDetailsService = new JdbcUserDetailsService(dataSource());
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return (Collection<? extends SimpleGrantedAuthority>) userDetails.getAuthorities();
    }

    private DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("myuser");
        dataSource.setPassword("mypassword");
        return dataSource;
    }
}

class JdbcUserDetailsService extends JdbcDaoImpl {
    public JdbcUserDetailsService(DataSource dataSource) {
        setDataSource(dataSource);
    }
}

public class Main {
    public static void main(String[] args) {
    }
}