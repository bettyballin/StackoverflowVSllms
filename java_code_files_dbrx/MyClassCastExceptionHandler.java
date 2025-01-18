import java.lang.String;
public class MyClassCastExceptionHandler {
    Object someOtherObject = new Object();
    MyClass myObject = (MyClass) someOtherObject;

    public static void main(String[] args) {
    }
}

class MyClass {
}