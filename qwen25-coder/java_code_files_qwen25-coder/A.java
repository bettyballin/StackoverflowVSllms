import java.lang.String;
// Define interface for interaction
interface InteractorA {
    void runMethodX();
}

// A implements this interface
class A implements InteractorA {
    public void runMethodX() { /*...*/ }
}

// B holds reference to A but does not expose it directly to C
class B {
    private final InteractorA a;
    
    // Constructor injection
    public B(InteractorA a) {
        this.a = a;
    }
    
    // Delegate method to A through interface
    public void runMethodXInA() {
        a.runMethodX();
    }
}

// C holds reference to B and can invoke the methods from B
public class C {
    private final B b;
    
    public C(B b) {
        this.b = b;
    }
    
    // Use delegated method
    public void performInteraction() {
        b.runMethodXInA();
    }

    public static void main(String[] args) {
    }
}