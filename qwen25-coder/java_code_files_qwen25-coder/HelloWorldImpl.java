import javax.jws.WebMethod;
import javax.jws.WebService;

// Interface
@WebService
interface HelloWorld {
    @WebMethod(operationName = "greetMessage")
    String getGreeting(String name);
}

// Implementation
@WebService(endpointInterface = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    public String getGreeting(String name) {
        return "Hello, " + name + "!";
    }
}