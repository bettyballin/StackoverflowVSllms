import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.DirContextOperations;

import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsContextMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // LDAP authentication
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://your-ldap-server:389");
        contextSource.setBase("ou=people,dc=springframework,dc=org");
        contextSource.setUserDn("your-user-dn");
        contextSource.afterPropertiesSet();

        auth.authenticationProvider(ldapAuthenticationProvider(contextSource));

        // Database authorization
        JdbcUserDetailsManager jdbcUserDetails = new JdbcUserDetailsManager();
        jdbcUserDetails.setDataSource(dataSource);
        jdbcUserDetails.setDataMapper(new CustomAuthoritiesMapper(this.dataSource)); // Implement or use a mapper like AuthoritiesByUsernameQuery

        auth.eraseCredentials(true).userDetailsService(jdbcUserDetails);
    }

    private AuthenticationProvider ldapAuthenticationProvider(ContextSource contextSource) {
        BindAuthenticator bindAuthenticator = new BindAuthenticator(contextSource);
        LdapAuthenticationProvider provider = new LdapAuthenticationProvider(bindAuthenticator);
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().fullyAuthenticated()
            .and()
            .formLogin();
    }
}

class CustomAuthoritiesMapper implements UserDetailsContextMapper {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public CustomAuthoritiesMapper(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {
        // Here you should implement how you retrieve roles from database based on username
        return new User(username, "", getAuthoritiesFromDatabase(ctx.getStringAttribute("uid")));
    }

    private List<GrantedAuthority> getAuthoritiesFromDatabase(String username) {
        String sql = "select role_name from roles where user_id = ?";
        List<GrantedAuthority> authorities = jdbcTemplate.query(sql, new Object[]{username}, (rs, rowNum) -> {
            String roleName = rs.getString("role_name");
            return new SimpleGrantedAuthority(roleName);
        });
        return authorities;
    }

    @Override
    public void mapUserToContext(UserDetails user, DirContextOperations ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {
    }
}