import org.springframework.remoting.rmi.RmiProxyFactoryBean;

public class DynamicRmiProxyFactoryBean extends RmiProxyFactoryBean {
  
  private String serviceInterface;
  private String serviceUrlTemplate;
  
  public void setServiceInterface(String serviceInterface) {
    this.serviceInterface = serviceInterface;
  }
  
  public void setServiceUrlTemplate(String serviceUrlTemplate) {
    this.serviceUrlTemplate = serviceUrlTemplate;
  }
  
  public Object getServiceFor(String hostName) {
    String serviceUrl = serviceUrlTemplate.replace("#{HOST}", hostName);
    setServiceUrl(serviceUrl);
    afterPropertiesSet();
    return getObject();
  }

  public static void main(String[] args) {
    // To test the compilation, you can add some code here
    DynamicRmiProxyFactoryBean factory = new DynamicRmiProxyFactoryBean();
    factory.setServiceInterface("some.interface.Name");
    factory.setServiceUrlTemplate("rmi://#{HOST}:1099/someService");
    Object service = factory.getServiceFor("localhost");
  }
}