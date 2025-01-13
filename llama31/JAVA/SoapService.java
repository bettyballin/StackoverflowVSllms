import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class SoapService {
  public String sayHello(String name) {
    return "Hello, " + name + "!";
  }

  public static void main(String[] args) {
    JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
    factory.setServiceClass(SoapService.class);
    factory.setAddress("http://localhost:8080/soap");
    factory.create();
  }
}