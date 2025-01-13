// Define the interface
public interface MyInterface {
    void methodInA();
}

// Define class A that implements the interface
public class A implements MyInterface {
    @Override
    public void methodInA() {
        // code here
        System.out.println("Method in A called");
    }
}

// Define class B that extends Thread
public class B extends Thread {
    private MyInterface instanceOfA;

    public B(MyInterface instanceOfA) {
        this.instanceOfA = instanceOfA;
    }

    @Override
    public void run() {
        C instanceOfC = new C(instanceOfA);
        instanceOfC.methodInC();
    }
}

// Define class C
public class C {
    private MyInterface instanceOfA;

    public C(MyInterface instanceOfA) {
        this.instanceOfA = instanceOfA;
    }

    public void methodInC() {
        instanceOfA.methodInA(); // calls method in Class A
    }
}

// Main class with the main method
public class Main {
    public static void main(String[] args) {
        // Create an instance of A
        A instanceOfA = new A();
        
        // Create an instance of B and pass the instance of A
        B instanceOfB = new B(instanceOfA);
        
        // Start the thread
        instanceOfB.start();
    }
}