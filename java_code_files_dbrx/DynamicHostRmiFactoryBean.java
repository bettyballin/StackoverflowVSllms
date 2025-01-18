import java.lang.String;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import org.springframework.stereotype.Component;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Component("dynamicHostRmiFactory")
public class DynamicHostRmiFactoryBean {
    private Class<?> serviceInterface;
    private String serviceUrlPrefix;
    private int portNumber;
    private String remoteServiceUrlSuffix;

    // Getters & setters ...

    public Object getRemoteService(String host) throws RemoteException, NotBoundException {
        RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
        rmiProxy.setServiceInterface(serviceInterface);
        String serviceUrl = buildServiceUrl(host);
        rmiProxy.setServiceUrl(serviceUrl);

        // Initialize the factory bean to prepare a remote connection
        rmiProxy.afterPropertiesSet();

        return rmiProxy.getObject();
    }

    private String buildServiceUrl(String host) {
        return serviceUrlPrefix + host + ":" + portNumber + remoteServiceUrlSuffix;
    }

    public static void main(String[] args) {
    }
}