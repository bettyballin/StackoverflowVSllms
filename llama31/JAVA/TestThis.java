import java.lang.String;
public class TestThis {
    public static void main(String[] args) {
        A a = new A();
        a.foo();
        
        B b = new B();
        b.bar();
    }
}

class A {
    public void foo() {
        System.out.println("Executing foo");
    }
}

class B {
    public void bar() {
        System.out.println("Executing bar");
    }
}