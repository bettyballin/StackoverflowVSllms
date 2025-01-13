import java.lang.String;

public class SynchronizationUtility_1_1 {
    MyClass myInstance = new MyClass();
    MyClass synchronizedInstance = SynchronizationUtility.synchronize(myInstance);

    public static void main(String[] args) {
    }
}

class MyClass {}

class SynchronizationUtility {
    public static MyClass synchronize(MyClass obj) {
        return obj;
    }
}