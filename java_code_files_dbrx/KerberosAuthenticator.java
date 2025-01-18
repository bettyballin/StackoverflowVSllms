import javax.security.auth.login.*;
import javax.security.auth.callback.*;
import java.io.IOException;
import java.util.Hashtable;

import com.sun.mail.imap.IMAPStore;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.URLName;

class KerberosAuthenticator extends Authenticator {  
    @Override   
    protected PasswordAuthentication getPasswordAuthentication() {     
        Configuration conf = Configuration.getConfiguration(); 
        Hashtable<String, Object> ht = new Hashtable<>();     
        System.out.println("Authenticating... please wait");

        // Set up the configuration properties for Kerberos     
        // These should be checked on your own server setup:

        ht.put("useFirstPass", true);      
        ht.put("username", "your_username");      
        ht.put("password", "your_password"); 
        try {       
            LoginContext lc = new LoginContext("Kerberos", new IMapCallbackHandler(ht));

            lc.login(); // login using the context     
        } catch (LoginException e) {        
            e.printStackTrace();    
        } 
        return null;  
    }
}      

class CustomImapStore extends IMAPStore { 
    public CustomImapStore(Session session, URLName urlname) {
        super(session, urlname);
    }

    public Authenticator getAuthenticator() {      
        return new KerberosAuthenticator();
    }
}

class IMapCallbackHandler implements CallbackHandler {     
    private Hashtable<String, Object> configs = null;

    public IMapCallbackHandler(Hashtable<String, Object> ht) {         
        configs = ht;
    }

    @Override 
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {    
        // check the type of callbacks and set your data      
        for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof NameCallback) {          
                ((NameCallback)callbacks[i]).setName(configs.get("username").toString()); // change to match your configuration
            } else if (callbacks[i] instanceof PasswordCallback) {
                ((PasswordCallback) callbacks[i]).setPassword(configs.get("password").toString().toCharArray());  
            }   
        }
    }
}