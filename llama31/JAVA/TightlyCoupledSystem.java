import java.lang.String;

// Bad practice: accessing implementation details directly
public class TightlyCoupledSystem {
    private UnderlyingSystem underlyingSystem;

    public TightlyCoupledSystem(UnderlyingSystem underlyingSystem) {
        this.underlyingSystem = underlyingSystem;
    }

    public void doSomething() {
        // accessing internal implementation details
        underlyingSystem.doInternalThing();
    }
}

// Good practice: using interfaces and encapsulation
public interface SystemInterface {
    void doSomething();
}

class UnderlyingSystem {
    public void doInternalThing() {
        System.out.println("Doing internal thing.");
    }
}

public class FlexibleSystem implements SystemInterface {
    private UnderlyingSystem underlyingSystem;

    public FlexibleSystem(UnderlyingSystem underlyingSystem) {
        this.underlyingSystem = underlyingSystem;
    }

    public void doSomething() {
        underlyingSystem.doInternalThing();
    }
}

// Benefits of abstraction and encapsulation
public class ClientCode {
    private SystemInterface system;

    public ClientCode(SystemInterface system) {
        this.system = system;
    }

    public void useSystem() {
        system.doSomething();
    }

    public static void main(String[] args) {
        UnderlyingSystem underlyingSystem = new UnderlyingSystem();
        TightlyCoupledSystem tightlyCoupledSystem = new TightlyCoupledSystem(underlyingSystem);
        tightlyCoupledSystem.doSomething();

        FlexibleSystem flexibleSystem = new FlexibleSystem(underlyingSystem);
        ClientCode clientCode = new ClientCode(flexibleSystem);
        clientCode.useSystem();
    }
}