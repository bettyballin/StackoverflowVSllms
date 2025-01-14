import java.lang.String;
class A {
    void methodA() {
        System.out.println("Method A is called");
    }
}

class B extends Thread {
    private C c;
    private A a;

    public B(A a) { // Constructor for passing instance of A to B
        this.a = a;
        this.c = new C(a); // Pass the same instance of A to C
    }

    @Override
    public void run() {
        c.someMethod();
    }
}

class C {
    private A a;

    public C(A a) { // Constructor for passing instance of A to C
        this.a = a;
    }

    void someMethod() {
        a.methodA(); // Call method from A using the passed reference
    }
}

public class Main_72 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        b.start(); // This will call run(), which in turn calls someMethod()
                   // and that calls methodA() of instance 'a'
    }
}