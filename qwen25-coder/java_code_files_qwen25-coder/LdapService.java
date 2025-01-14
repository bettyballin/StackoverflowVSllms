import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.stereotype.Service;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Service
public class LdapService {

    @Autowired
    private LdapTemplate ldapTemplate;

    // Replace "dc=example,dc=com" with the base DN of your LDAP server
    private String searchBase = "dc=example,dc=com";

    public boolean isUserExists(String email) {
        LdapQuery query = query()
                .base(searchBase)
                .where("uid").is(email);

        return ldapTemplate.findOne(query, User.class) != null;
    }

    // Optional: Define a POJO to map LDAP result if needed
    public static class User {
        private String uid;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }

    public static void main(String[] args) {
    }
}