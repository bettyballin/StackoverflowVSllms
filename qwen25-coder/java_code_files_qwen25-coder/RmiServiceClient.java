import org.springframework.remoting.rmi.RmiProxyFactoryBean;

public class RmiServiceClient {

    private String serviceInterface;
    private int port;
    private String serviceName;

    public RmiServiceClient(Class<?> serviceInterface, int port, String serviceName) {
        this.serviceInterface = serviceInterface.getName();
        this.port = port;
        this.serviceName = serviceName;
    }

    @SuppressWarnings("unchecked")
    public <T> T getServiceForHost(String host) throws Exception {
        RmiProxyFactoryBean factoryBean = new RmiProxyFactoryBean();
        factoryBean.setServiceUrl(String.format("rmi://%s:%d/%s", host, port, serviceName));
        factoryBean.setServiceInterface(Class.forName(serviceInterface));
        factoryBean.afterPropertiesSet(); // Initializes the proxy
        return (T) factoryBean.getObject();
    }

    public static void main(String[] args) {
    }
}