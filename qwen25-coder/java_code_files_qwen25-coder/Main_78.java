class Parent {
    Parent() {
        System.out.println("Parent Constructor");
    }
}

class Child extends Parent {
    Child() {
        super(); // Calls parent constructor automatically
    }
}

public class Main {
    public static void main(String[] args) {
        new Child(); // Output: Parent Constructor
    }
}