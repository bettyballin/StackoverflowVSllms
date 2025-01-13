// Define MyOtherClass in its own file: MyOtherClass.java
public class MyOtherClass {
    // ...
}

// Define MyClass in its own file: MyClass.java
public class MyClass_41 {
    private MyOtherClass other;

    public MyClass(MyOtherClass other) {
        this.other = other;
    }

    public static void main(String[] args) {
        MyClass obj1 = new MyClass(new MyOtherClass());
    }
}