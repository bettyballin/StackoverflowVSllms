import java.lang.reflect.Method;

public class MyClass_37_37 {
    public static void main(String[] args) {
        Class<?> clazz = MyClass_37.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}