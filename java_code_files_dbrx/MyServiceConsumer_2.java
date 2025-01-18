public class MyServiceConsumer_2 {
  private final BundleContext bundleContext; // injected via constructor / factory method etc.
  private ServiceReference ref; // added to hold the service reference

  public MyServiceConsumer_2(BundleContext bundleContext) {
    this.bundleContext = bundleContext;
  }

  public void doSomething() {
    ref = bundleContext.getServiceReference(MyService.class);
    if (ref != null) {
      try {
        getMyService().someMethod(42);
      } catch (Exception e) {
        // handle case when the service is not available, e.g., show an error message or fallback to a different behavior
      }
    } else {
      System.out.println("No matching services found");
    }
  }

  private MyService getMyService() throws InvalidSyntaxException {
    return (MyService) bundleContext.getService(ref); // could also use `ungetService` for resource management etc.
  }

  public static void main(String[] args) {
    // Example usage:
    BundleContext context = new BundleContextImpl();
    MyServiceConsumer_2 consumer = new MyServiceConsumer_2(context);
    consumer.doSomething();
  }

  // Definitions for missing classes and interfaces
  interface BundleContext {
    ServiceReference getServiceReference(Class<?> clazz);
    Object getService(ServiceReference ref);
  }

  interface ServiceReference {
  }

  interface MyService {
    void someMethod(int value);
  }

  class InvalidSyntaxException extends Exception {
  }

  // Example implementations for testing
  static class BundleContextImpl implements BundleContext {
    @Override
    public ServiceReference getServiceReference(Class<?> clazz) {
      if (clazz == MyService.class) {
        return new ServiceReferenceImpl();
      }
      return null;
    }

    @Override
    public Object getService(ServiceReference ref) {
      return new MyServiceImpl();
    }
  }

  static class ServiceReferenceImpl implements ServiceReference {
  }

  static class MyServiceImpl implements MyService {
    @Override
    public void someMethod(int value) {
      System.out.println("MyService.someMethod called with value: " + value);
    }
  }
}