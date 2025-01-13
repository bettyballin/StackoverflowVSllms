import javax.annotation.Resource;
import javax.xml.ws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import com.sun.xml.wss.impl.callback.UsernameToken;

@WebService
public class MyService_22_22 {
    @Resource
    private WebServiceContext context;

    public String doSomething() {
        // Get the username and password from the request
        MessageContext messageContext = context.getMessageContext();
        UsernameToken token = (UsernameToken) messageContext.get("com.sun.xml.wss.impl.callback.UsernameToken");

        // Verify the username and password against your database
        String username = token.getName();
        String password = token.getPassword();
        // ...

        // If authenticated, proceed with the request
        // ...
        return "Something Done!";
    }

    public static void main(String[] args) {
        MyService_22 myService = new MyService_22();
        System.out.println(myService.doSomething());
    }
}