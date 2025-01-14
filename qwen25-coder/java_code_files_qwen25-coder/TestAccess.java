public class TestAccess {
    // Assume this code is in a different file, e.g., TestAccess.java

    public static void main(String[] args) {
        A a = new A();
        a.foo();

        B b = new B();
        b.bar();
    }
}

class A {
    public void foo() {
        System.out.println("A.foo()");
    }
}

class B {
    public void bar() {
        System.out.println("B.bar()");
    }
}