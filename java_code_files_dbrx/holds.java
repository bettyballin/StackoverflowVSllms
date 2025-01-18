import java.lang.String;
import java.lang.reflect.Method;

public class holds {
    Method[] methods = SomeClass.class.getDeclaredMethods(); // This will get an array of method instances that each class holds.
    public static void main(String[] args) {
    }
}

class SomeClass {
}