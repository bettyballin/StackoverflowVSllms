interface Interface1{}

class Class2 implements Interface1 {}

class Class3 extends Class2 implements Interface1 {}

class Class1<T extends Class2 & Interface1> {
    // Class body can be empty or contain methods.
}

public class MainClass {
    public static void main(String[] args) {
        Class1<Class3> c = new Class1<>(); // Example usage where Class3 extends Class2 and implements Interface1.
    }
}