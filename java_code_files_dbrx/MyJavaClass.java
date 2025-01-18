import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.NoSuchAlgorithmException;
import java.security.KeyStoreException;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.TrustManager;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.BindingProvider;

import java.net.URL;

import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.UnsupportedCallbackException;

// Define WSPasswordCallback class (since it may not be available)
class WSPasswordCallback implements Callback {
    private String identifier;
    private String password;

    public WSPasswordCallback(String identifier, int usage) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class MyJavaClass {
    public static void main(String[] args) {
        try {
            // Load keyStore and provide password. This keystore will contain the private Key for the client's certificate.
            String ksName = "clientKeystore";
            String passwd = "changeit";
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream is = new FileInputStream(ksName);
            keyStore.load(is, passwd.toCharArray());
            is.close();

            // You could add this to your code so that you can select a certificate by alias if there are multiple available in the key store:
            String certAlias = "mycert"; //alias of your client certificate.
            PrivateKey privateKey = (PrivateKey) keyStore.getKey(certAlias, passwd.toCharArray());
            X509Certificate myCert[] = new X509Certificate[1];

            Provider p = new sun.security.pkcs11.SunPKCS11("configFileName"); // Provide the PKCS11 config file name

            // Load the truststore with our public certs (public keys of other clients, servers etc) and supply its password as well:
            String trustStoreName = "trustcertstore";
            InputStream inputTrustStoreStream = new FileInputStream(trustStoreName);
            KeyStore trustStore = null;
            try {
                trustStore = KeyStore.getInstance("JKS");
                trustStore.load(inputTrustStoreStream, passwd.toCharArray());
                inputTrustStoreStream.close();
            } catch (UnsupportedOperationException ex) {
                System.out.println("[Error] Unable to find PKCS11 Provider.");
                return;
            }

            // Instantiate the Trust Manager using our truststore:
            X509TrustManager tm = null;
            tm = new MyCustomSSLTrustManager(trustStore);

            // The previous lines may throw 'KeyStoreException', 'CertificateException','NoSuchAlgorithmException' or 'IOException'.
            // You should catch these exceptions and handle them appropriately in your code. Next, load the keystore data:
            KeyManagerFactory keyMgrFact = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyMgrFact.init(keyStore, passwd.toCharArray());
            SSLContext sslContext = null; // SSL context to be used in the connection layer
            try {
                if (tm != null)
                    sslContext = SSLContext.getInstance("TLS");
                else
                    return;
            } catch (NoSuchAlgorithmException e1) {
                System.out.println("[Error] Unable to find algorithm for setting up transport security.");
                return;
            }
            sslContext.init(keyMgrFact.getKeyManagers(), new TrustManager[]{tm}, null);

            // Create the WS Service: Remember your service name will be different from MyExampleService :
            QName qname = new QName("http://tempuri.org/", "MyExampleService"); // Replace 'tempuri' with your actual namespace and 'MyExampleService' with your specific endpoint.
            Service service = Service.create(new URL("http://localhost/wsdl"), qname); // Replace 'Your_wsdl_location' with the location of your WSDL description.

            MyExamplePortType myClient = service.getPort(MyExamplePortType.class); // Replace 'MyExamplePortType' with your specific port type.

            // Implement the CallbackHandler
            CallbackHandler callbackHandler = new CallbackHandler() {
                public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
                    for (int i = 0; i < callbacks.length; ++i) {
                        if (callbacks[i] instanceof WSPasswordCallback &&
                                ((WSPasswordCallback) callbacks[i]).getIdentifier().equals("MyExampleService")) { // Change 'MyExampleService' to your service name.
                            WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
                            // Password Callbacks should be treated by supplying the user password to their interface, this way:
                            if (pc != null) {
                                char[] cred_passwd = "yourPWD".toCharArray(); // Change 'yourPWD' with actual password.
                                pc.setPassword(new String(cred_passwd));
                                // Be careful not to overwrite your password accidentally!
                            } // End of 'if(pc!=null)'
                            return; // Returning from this method is important!
                        }
                    } // End of 'for loop'.
                }
            };
            // Usually, the callback handler is set in a handler chain or security context.
            // Set the handler on the BindingProvider
            ((BindingProvider) myClient).getRequestContext().put("javax.xml.ws.client.callback.handler", callbackHandler);

        } catch (javax.xml.ws.WebServiceException wse) {
            System.out.println("[Error] Exception while Creating the Service: " + wse);
        } catch (Exception ex) {
            System.out.println("[Error] Exception: " + ex);
        }
    }
}

// Define MyCustomSSLTrustManager class
class MyCustomSSLTrustManager implements X509TrustManager {
    public MyCustomSSLTrustManager(KeyStore trustStore) throws KeyStoreException, NoSuchAlgorithmException {
        // Implement trust manager initialization with provided trustStore
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
        // Implement client trust check
    }

    public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
        // Implement server trust check
    }
}

// Define MyExamplePortType interface
interface MyExamplePortType {
    // Define methods corresponding to your web service operations
}