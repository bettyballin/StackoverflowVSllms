import java.util.HashMap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;

@WebService
public class MyService_25 {
    @WebMethod
    public String greet(@WebParam(name = "name") String name) {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        Bus bus = BusFactory.getDefaultBus();
        Endpoint endpoint = Endpoint.publish("http://localhost:8080/myService", new MyService());

        // Enable WS-Security with username/password authentication
        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor();
        wssOut.setProperties(new HashMap<String, Object>() {{
            put("action", "UsernameToken");
            put("user", "username");
            put("passwordCallbackClass", "com.example.PasswordCallback");
        }});
        endpoint.getOutInterceptors().add(wssOut);
    }
}