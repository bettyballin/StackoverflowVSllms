import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.*;

import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

public class LDAPConnectionChecker {

    public static boolean isConnectionValid(String ldapUrl, String userDN, String password) {
        LdapContext ctx = null;
        try {
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, ldapUrl);
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, userDN);
            env.put(Context.SECURITY_CREDENTIALS, password);

            ctx = new InitialLdapContext(env, null);

            // Perform a whoami operation to check the connection
            WhoAmIRequest whoAmIRequest = new WhoAmIRequest();
            WhoAmIResponse whoAmIResponse = (WhoAmIResponse) ctx.extendedOperation(whoAmIRequest);
            String authzId = whoAmIResponse.getAuthzId();

            // If we reach here without exception, connection is valid
            return true;
        } catch (NamingException e) {
            // Handle exception if necessary.
            return false;
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException e) {
                    // Log or handle close exception
                }
            }
        }
    }

    public static void main(String[] args) {
        String ldapUrl = "ldap://your.ldap.server.com:389";
        String userDN = "cn=admin,dc=example,dc=com";
        String password = "secret";

        boolean isValid = isConnectionValid(ldapUrl, userDN, password);
        System.out.println("LDAP connection is valid: " + isValid);
    }

    // Static inner class to perform WhoAmIRequest
    static class WhoAmIRequest implements ExtendedRequest {

        public static final String WHO_AM_I_REQ_OID = "1.3.6.1.4.1.4203.1.11.3";

        @Override
        public String getID() {
            return WHO_AM_I_REQ_OID;
        }

        @Override
        public byte[] getEncodedValue() {
            return null; // No value for this request
        }

        @Override
        public ExtendedResponse createExtendedResponse(String id, byte[] berValue, int offset, int length) throws NamingException {
            return new WhoAmIResponse(id, berValue, offset, length);
        }
    }

    // Static inner class to process WhoAmIResponse
    static class WhoAmIResponse implements ExtendedResponse {

        private String authzId;

        public WhoAmIResponse(String id, byte[] berValue, int offset, int length) throws NamingException {
            if (berValue != null) {
                try {
                    authzId = new String(berValue, offset, length, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new NamingException("UTF-8 encoding not supported");
                }
            } else {
                authzId = null;
            }
        }

        @Override
        public String getID() {
            return WhoAmIRequest.WHO_AM_I_REQ_OID;
        }

        @Override
        public byte[] getEncodedValue() {
            return null;
        }

        public String getAuthzId() {
            return authzId;
        }
    }
}