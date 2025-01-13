import java.io.IOException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;
import java.security.UnrecoverableKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class DigitalSignatureUtil {
    String alias = "Alias to my PK";
    char[] pass = "MyPassword".toCharArray();

    public DigitalSignatureUtil() throws Exception {
        KeyStore ks = KeyStore.getInstance("Windows-MY");
        ks.load(null, pass);
        Provider p =  ks.getProvider();

        Signature sig = Signature.getInstance("SHA1withRSA", p);

        // Set a callback handler to handle the password request
        CallbackHandler callbackHandler = new CallbackHandler() {
            @Override
            public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
                for (Callback callback : callbacks) {
                    if (callback instanceof PasswordCallback) {
                        PasswordCallback passwordCallback = (PasswordCallback) callback;
                        passwordCallback.setPassword(pass);
                    }
                }
            }
        };
        sig.setCallbackHandler(callbackHandler);

        PrivateKey key = (PrivateKey) ks.getKey(alias, pass);
        sig.initSign(key);
        sig.update("Testing".getBytes());
        sig.sign();
    }

    public static void main(String[] args) {
        try {
            new DigitalSignatureUtil();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}