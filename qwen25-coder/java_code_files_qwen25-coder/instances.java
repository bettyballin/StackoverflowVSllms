import java.lang.String;
public class instances {
    public void loadExtensions() {
        IExtensionRegistry reg = Platform.getExtensionRegistry();
        IExtensionPoint extPoint = reg.getExtensionPoint("com.example.monitor.custom.servers");
        for (IConfigurationElement config : extPoint.getConfigurationElements()) {
            try {
                // Dynamically create and register new Server class instances
                Object obj = config.createExecutableExtension("class");
                if(obj instanceof Server) {
                    Configuration.getInstance().getServers().add((Server)obj);
                }
            } catch(CoreException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
    }
}

class Platform {
    public static IExtensionRegistry getExtensionRegistry() {
        return new IExtensionRegistry();
    }
}

class IExtensionRegistry {
    public IExtensionPoint getExtensionPoint(String s) {
        return new IExtensionPoint();
    }
}

class IExtensionPoint {
    public IConfigurationElement[] getConfigurationElements() {
        return new IConfigurationElement[]{new IConfigurationElement()};
    }
}

class IConfigurationElement {
    public Object createExecutableExtension(String s) throws CoreException {
        return new Server();
    }
}

class Server {
}

class Configuration {
    private static Configuration instance = new Configuration();
    public static Configuration getInstance() {
        return instance;
    }

    public Servers getServers() {
        return new Servers();
    }
}

class Servers {
    public void add(Server obj) {
    }
}

class CoreException extends Exception {
}