// Define Interface1
interface Interface1 {
    void method1();
}

// Define Class2
class Class2 {}

// The original code snippet
class Class1<I extends Interface1, T extends Class2 & I> {
    public void method(T t) {
        // Example usage of T
        t.method1();
    }
}

// Main class to demonstrate the usage of Class1
public class Main_757 {
    public static void main(String[] args) {
        // To use Class1, we need a class that extends Class2 and implements Interface1
        class ConcreteClass extends Class2 implements Interface1 {
            @Override
            public void method1() {
                System.out.println("method1 invoked");
            }
        }
        
        Class1<Interface1, ConcreteClass> instance = new Class1<>();
        instance.method(new ConcreteClass());
    }
}