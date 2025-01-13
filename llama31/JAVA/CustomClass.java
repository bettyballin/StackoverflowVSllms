import java.lang.reflect.Method;

public class CustomClass {
    public void method() {}

    // Attempting to declare a custom bridge method
    public void bridgeMethod() {}
}

public class Main {
    public static void main(String[] args) throws Exception {
        CustomClass customClass = new CustomClass();
        Method method = customClass.getClass().getMethod("bridgeMethod");
        System.out.println(method.isBridge()); // prints: false
    }
}