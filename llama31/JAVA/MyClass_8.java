import java.lang.Integer;
import java.lang.String;
public class MyClass_8 {
    public static boolean isSubclass(Class<?> clazz, Class<?> superClass) {
        return superClass.isAssignableFrom(clazz);
    }

    public static void main(String[] args) {
        System.out.println(isSubclass(Integer.class, Number.class)); // true
        System.out.println(isSubclass(Number.class, Integer.class)); // false
    }
}