import java.lang.String;
class Base {}
class Sub extends Base {}
class SubSub extends Sub {}

public class MethodOverloadExample {
    public static void doSomething(Base b) {
        System.out.println("BASE CALLED");
    }

    public static void doSomething(Sub b) {
        System.out.println("SUB CALLED");
    }

    public static void doSomething(SubSub b) {
        System.out.println("SUBSUB CALLED");
    }

    public static void main(String[] args) {
        SubSub ss = new SubSub();
        doSomething(ss); // Output: SUBSUB CALLED
    }
}