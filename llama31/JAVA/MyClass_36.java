// Java code
import java.lang.String;

public class MyClass_36 {
    public void doSomething(String s) { System.out.println("String version"); }
    public void doSomething(MyClass obj) { System.out.println("MyClass version"); }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.doSomething((MyClass) null); // prints "MyClass version"
        // obj.doSomething(null); // compiler error (ambiguous method call)
    }
}