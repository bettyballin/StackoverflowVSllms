import java.util.Dictionary;
import java.util.Hashtable;

interface BundleContext {
    <S> ServiceReference<S> getServiceReference(Class<S> clazz, String filter);
    <S> S getService(ServiceReference<S> reference);
}

interface ServiceReference<S> {
}

interface ComponentFactory {
    ComponentInstance newInstance(Dictionary<String, Object> properties);
}

interface ComponentInstance {
    Object getInstance();
}

class MyThirdClass {
    public void setArg1(String value) {
        // Implementation here
    }
    public void setArg2(int value) {
        // Implementation here
    }
}

class MyBundleContext implements BundleContext {
    public <S> ServiceReference<S> getServiceReference(Class<S> clazz, String filter) {
        return new MyServiceReference<S>();
    }
    public <S> S getService(ServiceReference<S> reference) {
        if (reference instanceof MyServiceReference) {
            return (S) new MyComponentFactory();
        }
        return null;
    }
}

class MyServiceReference<S> implements ServiceReference<S> {
}

class MyComponentFactory implements ComponentFactory {
    public ComponentInstance newInstance(Dictionary<String, Object> properties) {
        return new MyComponentInstance();
    }
}

class MyComponentInstance implements ComponentInstance {
    public Object getInstance() {
        return new MyThirdClass();
    }
}

public class Main {

    public static void main(String[] args) {
        BundleContext context = new MyBundleContext(); // Obtain from your activator or elsewhere
        ServiceReference<ComponentFactory> ref = context.getServiceReference(ComponentFactory.class, "(factory=MyThirdClass.Factory)");
        ComponentFactory factory = context.getService(ref);

        Dictionary<String, Object> properties = new Hashtable<>();
        ComponentInstance instance = factory.newInstance(properties);

        MyThirdClass myInstance = (MyThirdClass) instance.getInstance();
        myInstance.setArg1("value");
        myInstance.setArg2(42);
    }
}