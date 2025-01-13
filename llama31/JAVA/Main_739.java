import javax.xml.ws.Service;
import javax.xml.ws.security.UsernameToken;
import javax.xml.namespace.QName;
import java.net.URL;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.security.PasswordType;

public class Main_739 {
    public static void main(String[] args) throws Exception {
        // Create a webservice client
        URL url = new URL("http://your-service-url?wsdl");
        QName qName = new QName("http://your-service-namespace", "MyService");
        Service service = Service.create(url, qName);
        MyService port = service.getPort(MyService.class);

        // Create a username token with the client's credentials
        UsernameToken token = new UsernameToken("client-username", "client-password", PasswordType.PASSWORD_TEXT);

        // Add the username token to the request
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, token.getUsername());
        bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, token.getPassword());

        // Call the webservice
        String response = port.doSomething();
        System.out.println(response);
    }
}

// Assuming MyService interface is defined as follows
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(targetNamespace = "http://your-service-namespace")
public interface MyService {
    @WebMethod
    String doSomething();
}