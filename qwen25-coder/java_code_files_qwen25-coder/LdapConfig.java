import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.core.LdapTemplate;

@Configuration
public class LdapConfig {

    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource source = new LdapContextSource();
        source.setUrl("ldap://localhost:389");
        source.setBase("dc=mycompany,dc=com");
        source.setUserDn("admin");
        source.setPassword("password");
        return source;
    }

    @Bean
    public LdapTemplate ldapTemplate() {
        return new LdapTemplate(contextSource());
    }

    public static void main(String[] args) {
    }
}