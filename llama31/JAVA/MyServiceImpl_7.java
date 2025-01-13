import java.lang.String;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

// Web Service interface
@WebService
public interface MyService {
    @WebMethod
    String sayHello(@WebParam(name = "name") String name);
}

// Web Service implementation
public class MyServiceImpl_7_7 implements MyService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}

// Web Service client
public class MyClient {
    public static void main(String[] args) {
        // Create a CXF client
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(MyService.class);
        factory.setAddress("http://localhost:8080/MyService");
        
        // Create a proxy instance
        MyService service = (MyService) factory.create();
        
        // Call the web service method
        String response = service.sayHello("John");
        System.out.println(response);
    }
}