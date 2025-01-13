/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Method;

public class loader {
    public static void main(String[] stringArray) throws Exception {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        for (int i = 0; i < 5; ++i) {
            Class<?> clazz = customClassLoader.loadClass("MyJavaProgram");
            Object obj = clazz.newInstance();
            Method method = clazz.getMethod("main", String[].class);
            method.invoke(obj, new Object[]{new String[0]});
        }
    }
}
