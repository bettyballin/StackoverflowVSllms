import java.lang.String;
import java.io.Serializable;

public class Parent_3 {

    class Parent implements Serializable {
        private static final long serialVersionUID = 1L;
        // fields, constructors, methods...
    }

    class Child extends Parent {
        // This class is also serializable because its parent is serializable.
    }

    public static void main(String[] args) {
    }
}