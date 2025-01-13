public class B {
    // ...

    public static void main(String[] args) {
        B sharedObject = new B();
        A_5 a = new A_5(sharedObject);
    }
}

class A_5 {
    private B sharedObject;

    public A_5(B sharedObject) {
        this.sharedObject = sharedObject;
    }
}