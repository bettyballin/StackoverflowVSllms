import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.xml.ws.Endpoint;
import org.apache.cxf.annotations.Addressing;
import org.apache.cxf.annotations.Policy;

@WebService
@Addressing
@Policy(uri = "http://schemas.xmlsoap.org/ws/2004/09/policy")
public class MyService_15 {

    @WebMethod
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/myservice", new MyService());
        System.out.println("Service is running...");
    }
}