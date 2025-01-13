import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.ldap.LdapContext;

public class LdapConnector_2_2 {
    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();
            LdapContext ldapCtx = (LdapContext) ctx.lookup("ldapPool");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}