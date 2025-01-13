// Define the MyObject class
class MyObject {
    public void doSomething() {
        System.out.println("Doing something...");
    }
}

// Define the MyObjectProcessor_1 class
public class MyObjectProcessor_1_1 {
    public void process(final MyObject obj) {
        // obj cannot be reassigned, but its state can still be modified
        obj.doSomething(); // allowed
        // obj = new MyObject(); // compiler error
    }

    public static void main(String[] args) {
        MyObjectProcessor_1 processor = new MyObjectProcessor_1();
        MyObject obj = new MyObject();
        processor.process(obj);
    }
}