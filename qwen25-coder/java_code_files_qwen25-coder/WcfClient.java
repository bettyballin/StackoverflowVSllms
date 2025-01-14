import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.ws.security.handler.WSHandlerConstants;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class WcfClient {
    public static void main(String[] args) throws Exception {
        // Initialize the service
        YourService service = new YourService();
        YourPortType portType = service.getYourPort();

        Client client = ClientProxy.getClient(portType);

        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();

        // SSL Configuration
        setupSSL(httpConduit);

        // Sign and Encrypt using WSS4JOutInterceptor
        Map<String, Object> outProps = new HashMap<>();
        outProps.put(WSHandlerConstants.ACTION, "Timestamp Signature Encrypt");
        outProps.put(WSHandlerConstants.USER, "client_key_alias");
        outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientKeystorePasswordCallback.class.getName());
        outProps.put(WSHandlerConstants.SIGNATURE_PARTS, "{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd}Body");
        outProps.put(
            WSHandlerConstants.ENCRYPTION_USER,
            "service_cert_alias"
        );
        outProps.put(WSHandlerConstants.SIG_PROP_FILE, "clientKeystore.properties");
        outProps.put(WSHandlerConstants.ENC_PROP_FILE, "clientKeystore.properties");

        WSS4JOutInterceptor wss4jOut = new WSS4JOutInterceptor(outProps);
        client.getOutInterceptors().add(wss4jOut);

        // Use the service
        String result = portType.yourServiceMethod("parameter");
    }

    private static void setupSSL(HTTPConduit httpConduit) throws Exception {
        KeyManager[] keyManagers = getKeyManagerArray();
        TrustManager[] trustManagers = getTrustManagerArray();

        TLSClientParameters tlsParams = new TLSClientParameters();
        tlsParams.setKeyManagers(keyManagers);
        tlsParams.setTrustManagers(trustManagers);
        tlsParams.setDisableCNCheck(true); // For testing purposes

        httpConduit.setTlsClientParameters(tlsParams);
    }

    private static KeyManager[] getKeyManagerArray() throws Exception {
        char[] password = "keyStorePassword".toCharArray();
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream inputStream = new FileInputStream("yourKeystore.jks");
        try {
            keyStore.load(inputStream, password);
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, password);
            return kmf.getKeyManagers();
        } finally {
            inputStream.close();
        }
    }

    private static TrustManager[] getTrustManagerArray() throws Exception {
        char[] password = "trustStorePassword".toCharArray();
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream inputStream = new FileInputStream("yourTruststore.jks");
        try {
            trustStore.load(inputStream, password);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);
            return tmf.getTrustManagers();
        } finally {
            inputStream.close();
        }
    }
}

class YourService {
    public YourPortType getYourPort() {
        return new YourPortType();
    }
}

class YourPortType {
    public String yourServiceMethod(String parameter) {
        // Implementation of your service method
        return "Service response with parameter: " + parameter;
    }
}

class ClientKeystorePasswordCallback implements CallbackHandler {
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        // Handle password callbacks
    }
}