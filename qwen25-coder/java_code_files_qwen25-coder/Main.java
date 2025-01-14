public class Main {
    public static void main(String[] args) {
        B b = new B();
        b.getA().runMethodX();
    }
}

class A {
    public void runMethodX() {
        // Implementation of Method X
        System.out.println("Method X is running.");
    }
}

class B {
    public A getA() {
        return new A();
    }
}