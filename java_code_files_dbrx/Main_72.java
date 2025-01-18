interface IFactory {
    public String foo();
}

class A implements IFactory {
    public String foo() {
        return "Executing foo";
    }
}

class FooBarFactory {
    public static IFactory create(String s) {
        if (s.equals("A")) {
            return new A();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        IFactory aObj = FooBarFactory.create("A");
        System.out.println(aObj.foo()); //This would print "Executing foo" if your A class is implemented correctly for the IFactory interface and its methods
    }
}