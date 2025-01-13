import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Value;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class MyConfig {
  
  @Value("${webServer.host}")
  private String host;
  
  @Bean
  public MyService myService() {
    RmiProxyFactoryBean factory = new RmiProxyFactoryBean();
    factory.setServiceUrl("rmi://" + host + ":80/MyService");
    factory.setServiceInterface(MyService.class);
    return (MyService) factory.getObject();
  }

  public static void main(String[] args) {
  }
}