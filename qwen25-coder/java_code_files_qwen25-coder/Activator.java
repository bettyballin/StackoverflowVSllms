import java.lang.String;

interface BundleActivator {
    void start(BundleContext context) throws Exception;
    void stop(BundleContext context) throws Exception;
}

class BundleContext {
}

class ServiceTracker<T, S> {
    public ServiceTracker(BundleContext context, Class<T> clazz, Object obj) {
        // Constructor body
    }
    public void open() {
        // Open tracker
    }
    public void close() {
        // Close tracker
    }
    public S getService() {
        return null;
    }
}

class ComponentB {
}

public class Activator implements BundleActivator {
    private static ServiceTracker<ComponentB, ComponentB> componentBTracker;

    @Override
    public void start(BundleContext context) throws Exception {
        componentBTracker = new ServiceTracker<>(context, ComponentB.class, null);
        componentBTracker.open();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        componentBTracker.close();
    }

    public static ComponentB getComponentB() {
        return componentBTracker.getService();
    }

    public static void main(String[] args) {
    }
}