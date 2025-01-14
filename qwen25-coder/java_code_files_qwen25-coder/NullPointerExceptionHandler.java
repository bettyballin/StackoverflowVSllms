import java.lang.String;
public class NullPointerExceptionHandler {
    public static void main(String[] args) {
        MyClass myObject = null;

        if (myObject != null) {
            myObject.func();
        } else {
            // Handle null case, possibly throw an exception or log it
            throw new NullPointerException("Attempted to call func() on a null object.");
        }
    }
}

class MyClass {
    public void func() {
        // Empty method
    }
}