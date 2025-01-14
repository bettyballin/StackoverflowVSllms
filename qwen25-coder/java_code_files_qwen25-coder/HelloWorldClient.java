import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class HelloWorldClient {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8091/helloworld?wsdl");
        QName qname = new QName("http://example.org/wsdl", "HelloWorldService");

        Service service = Service.create(url, qname);
        HelloWorld helloworld = service.getPort(HelloWorld.class);

        String result = helloworld.sayHello();
        System.out.println(result);
    }
}

interface HelloWorld {
    String sayHello();
}