// Define ServiceB
public class ServiceB {
    public void doSomething() {
        System.out.println("ServiceB is doing something");
    }
}

// Tightly coupled services
public class ServiceA {
    private ServiceB serviceB;
    
    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }
    
    public void serveClient() {
        // depends on ServiceB to function
        serviceB.doSomething();
    }
}

// Autonomous services
public class AutonomousServiceA {
    public void serveClient() {
        // does not depend on another service to function
        // can use a message queue or other decoupling mechanism
        // to communicate with other services if needed
        System.out.println("AutonomousServiceA is serving client");
    }

    public static void main(String[] args) {
        ServiceB serviceB = new ServiceB();
        ServiceA serviceA = new ServiceA(serviceB);
        serviceA.serveClient();

        AutonomousServiceA autonomousServiceA = new AutonomousServiceA();
        autonomousServiceA.serveClient();
    }
}