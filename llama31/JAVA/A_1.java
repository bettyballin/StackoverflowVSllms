import java.lang.String;

class A {
    public void methodInA() {
        // code here
    }
}

class B extends Thread {
    private A instanceOfA;

    public B(A instanceOfA) {
        this.instanceOfA = instanceOfA;
    }

    @Override
    public void run() {
        C instanceOfC = new C(instanceOfA);
        instanceOfC.methodInC();
    }
}

class C {
    private A instanceOfA;

    public C(A instanceOfA) {
        this.instanceOfA = instanceOfA;
    }

    public void methodInC() {
        instanceOfA.methodInA(); // calls method in Class A
    }
}

public class Main {
    public static void main(String[] args) {
        A instanceOfA = new A();
        B instanceOfB = new B(instanceOfA);
        instanceOfB.start();
    }
}