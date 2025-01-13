import java.lang.String;

public class ClassHierarchyChecker {
    public static boolean isSubclass(Class<?> clazz, Class<?> superClass) {
        return superClass.isAssignableFrom(clazz) && !superClass.isInterface();
    }

    public static void main(String[] args) {
    }
}