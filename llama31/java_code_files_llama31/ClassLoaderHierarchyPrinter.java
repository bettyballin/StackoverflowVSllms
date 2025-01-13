/*
 * Decompiled with CFR 0.152.
 */
public class ClassLoaderHierarchyPrinter {
    public static void main(String[] stringArray) {
        System.out.println("Classloader hierarchy:");
        System.out.println(ClassLoaderHierarchyPrinter.class.getClassLoader());
        System.out.println(ClassLoaderHierarchyPrinter.class.getClassLoader().getParent());
        System.out.println(ClassLoaderHierarchyPrinter.class.getClassLoader().getParent().getParent());
    }
}
