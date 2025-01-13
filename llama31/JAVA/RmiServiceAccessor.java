import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiServiceAccessor {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DynamicRmiProxyFactoryBean factory = (DynamicRmiProxyFactoryBean) applicationContext.getBean("dynamicRmiProxyFactory");
        Object service = factory.getServiceFor("hostname");
    }
}