import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

import java.util.List;

public class LdapSearcher {
    LdapTemplate ldapTemplate;
    String filter;
    String base;
    List<String> result;

    public LdapSearcher() {
        LdapContextSource ldapContextSource = new LdapContextSource();
        // You need to set up the ldapContextSource, 
        // for example, set the url, base, userDn and password
        ldapContextSource.setUrl("ldap://your-ldap-server:389");
        ldapContextSource.setBase("dc=example,dc=com");
        ldapContextSource.setUserDn("cn=admin,dc=example,dc=com");
        ldapContextSource.setPassword("password");

        ldapTemplate = new LdapTemplate(ldapContextSource);

        filter = "(|(ou=12345)(ou=23452)(ou=34352))(uid=some@email.com)";
        base = ""; // base DN of the search

        result = ldapTemplate.search(base, filter, new String[] {"dn"});
    }

    public static void main(String[] args) {
        LdapSearcher ldapSearcher = new LdapSearcher();
        System.out.println(ldapSearcher.result);
    }
}