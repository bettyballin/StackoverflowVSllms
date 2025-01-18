import java.lang.String;

public class ClassCastExceptionGenerator {
    public static void main(String[] args) {
        Object someOtherObject = new Object();

        if (!(someOtherObject instanceof MyClass)) {
            throw new ClassCastException("Cannot cast " + someOtherObject + " to " + MyClass.class.getName());
        }
    }
}

class MyClass {
}