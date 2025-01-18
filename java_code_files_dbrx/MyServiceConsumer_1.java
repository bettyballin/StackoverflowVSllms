import java.lang.String;

public class MyServiceConsumer_1 {
  private final ServiceTracker serviceTracker; // initialized in constructor / via a factory method etc.

  public MyServiceConsumer_1() {
    // Initialize serviceTracker
    this.serviceTracker = new ServiceTracker();
  }

  public void doSomething() {
    MyService myService = getMyService();
    if (myService != null) {
      myService.someMethod(42);
    } else {
      // handle case when the service is not available, e.g., show an error message or fallback to a different behavior
    }
  }

  private MyService getMyService() {
    return (MyService) serviceTracker.getService();
  }

  public static void main(String[] args) {
    MyServiceConsumer_1 consumer = new MyServiceConsumer_1();
    consumer.doSomething();
  }
}

class ServiceTracker {
  public Object getService() {
    // Return a MyService instance or null
    return new MyServiceImpl();
  }
}

interface MyService {
  void someMethod(int x);
}

class MyServiceImpl implements MyService {
  public void someMethod(int x) {
    System.out.println("someMethod called with " + x);
  }
}