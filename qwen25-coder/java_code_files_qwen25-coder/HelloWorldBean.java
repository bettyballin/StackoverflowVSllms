// Simple Stateless Session Bean Example

// Import necessary annotation classes
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Define the @Stateless annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Stateless {
}

// Define the HelloWorld interface
interface HelloWorld {
    String sayHello(String name);
}

@Stateless
public class HelloWorldBean implements HelloWorld {
    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        // Create an instance of HelloWorldBean
        HelloWorldBean bean = new HelloWorldBean();
        // Call the sayHello method and print the result
        System.out.println(bean.sayHello("World"));
    }
}