import java.lang.String;
import java.lang.Integer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyServiceConfigurator {
    String host = "localhost";
    int port = 80;
    ApplicationContext context = new GenericXmlApplicationContext("context.xml");
    MyService myService;

    {
        ((AbstractApplicationContext) context).getEnvironment().setProperty("app.host", host);
        ((AbstractApplicationContext) context).getEnvironment().setProperty("app.port", Integer.toString(port));
        myService = (MyService) context.getBean("myService ");
    }

    public static void main(String[] args) {
    }
}