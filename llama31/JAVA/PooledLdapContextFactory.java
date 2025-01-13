import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.spi.NamingManager;
import javax.naming.spi.ObjectFactory;

import org.springframework.ldap.core.LdapContextSource;

public class PooledLdapContextFactory implements ObjectFactory {
    private LdapContextSource contextSource;

    public PooledLdapContextFactory(LdapContextSource contextSource) {
        this.contextSource = contextSource;
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        return contextSource.getLdapContext();
    }

    public static void main(String[] args) {
    }
}