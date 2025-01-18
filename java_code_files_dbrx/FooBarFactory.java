interface IFactory {
    String foo();
    String bar();
}

class A implements IFactory {
    // Implement foo() method.
    public String foo() {
        return "Result from A's foo() method";
    }
    
    // Provide implementation for bar() method.
    public String bar() {
        return null;
    }
}

class B implements IFactory {
    // Provide implementation for foo() method.
    public String foo() {
        return null;
    }
    
    // Implement bar() method.
    public String bar() {
        return "Result from B's bar() method";
    }
}

public class FooBarFactory {
   public static IFactory create(String type) {
        if ("A".equalsIgnoreCase(type)) return new A();
        else if ("B".equalsIgnoreCase(type)) return new B();
        throw new IllegalArgumentException("Invalid type: " + type);
   }
}