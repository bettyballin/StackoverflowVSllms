import java.lang.String;

public class ClassLoaderHierarchyPrinter {
    public static void main(String[] args) {
        System.out.println("Classloader hierarchy:");
        System.out.println(ClassLoaderHierarchyPrinter.class.getClassLoader());
        System.out.println(ClassLoaderHierarchyPrinter.class.getClassLoader().getParent());
        System.out.println(ClassLoaderHierarchyPrinter.class.getClassLoader().getParent().getParent());
    }
}