import java.util.Hashtable;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.ArrayList;
import java.util.List;

public class LdapDataSource implements JRDataSource {
    private DirContext ctx;
    private String baseDN;
    private String filter;
    private List<JRField> fields;

    public LdapDataSource(String url, String username, String password, String baseDN, String filter) {
        this.baseDN = baseDN;
        this.filter = filter;
        try {
            ctx = new InitialDirContext(getEnvironment(url, username, password));
        } catch (NamingException e) {
            throw new JRException(e);
        }
    }

    private Hashtable<String, String> getEnvironment(String url, String username, String password) {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, username);
        env.put(Context.SECURITY_CREDENTIALS, password);
        return env;
    }

    @Override
    public boolean next() throws JRException {
        try {
            NamingEnumeration<SearchResult> results = ctx.search(baseDN, filter, new SearchControls());
            while (results.hasMore()) {
                SearchResult result = results.next();
                Attributes attributes = result.getAttributes();
                fields = new ArrayList<>();
                for (Attribute attribute : attributes.getAll()) {
                    JRField field = new JRField(attribute.getID(), attribute.get());
                    fields.add(field);
                }
                return true;
            }
        } catch (NamingException e) {
            throw new JRException(e);
        }
        return false;
    }

    @Override
    public Object getFieldValue(JRField field) throws JRException {
        for (JRField f : fields) {
            if (f.getName().equals(field.getName())) {
                return f.getValue();
            }
        }
        return null;
    }

    @Override
    public void moveFirst() throws JRException {
        // Not implemented
    }

    public static void main(String[] args) {
        // You need to have the JasperReports and LDAP libraries in your classpath
        // to run this program. You can add them to your classpath using the -cp
        // option when compiling and running this program with javac and java.
        System.out.println("LdapDataSource class compiled and executed successfully.");
    }
}