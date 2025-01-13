// Define the MyComComponent class in the mycomcomponent package
package mycomcomponent;

public class MyComComponent {
    public void myMethod() {
        System.out.println("myMethod called");
    }
}

// Main class
import mycomcomponent.MyComComponent;

public class Main_155 {
    public static void main(String[] args) {
        // Create an instance of the COM component
        MyComComponent component = new MyComComponent();

        // Call a method on the COM component
        component.myMethod();
    }
}