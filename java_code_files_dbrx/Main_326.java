// Using Apache CXF library to sign a SOAP header with WS-Security
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor();
        Map<String, Object> outProps = new HashMap<>(); // configure properties such as usernames, timestamps and signatures here
        wssOut.setProperties(outProps);
    }
}