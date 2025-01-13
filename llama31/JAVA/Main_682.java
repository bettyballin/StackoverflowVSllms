// Main.java
import java.lang.reflect.Method;

public class Main_682 {
    public static void main(String[] args) throws Exception {
        Object handler = Class.forName("com.mypackage.Handler").newInstance();
        Method myMethod = handler.getClass().getMethod("myMethod", String[].class);
        String[] myArray = new String[]{"value1", "value2"};
        myMethod.invoke(handler, (Object) myArray);
    }
}