import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

public class MyClass_17_17 {
    public static void main(String[] args) throws Exception {
        Method method = MyClass_17.class.getMethod("myMethod", List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        System.out.println(genericParameterTypes[0]); // prints "java.util.List<java.lang.String>"
    }

    public static void myMethod(List<String> list) {
        // ...
    }
}