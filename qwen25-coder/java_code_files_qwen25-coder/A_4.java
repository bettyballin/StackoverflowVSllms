import java.lang.String;
// Class that needs the shared 'B' object
public class A_4 {
    private B sharedB;

    // Injecting 'B' through constructor
    public A_4(B b) {
        this.sharedB = b;
    }

    public void doSomething() {
        // Use sharedB as needed
        sharedB.someMethod();
    }
}

// Shared class B
class B {
    public void someMethod() {
        System.out.println("Doing something in B");
    }

    public static void main(String[] args) {
    }
}