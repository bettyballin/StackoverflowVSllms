/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Method;

public class DynamicMethodInvoker {
    public static void main(String[] stringArray) throws Exception {
        String string = "MyClass";
        String string2 = "myMethod";
        Object[] objectArray = new Object[]{"Hello", 123};
        Class<?> clazz = Class.forName(string);
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod(string2, String.class, Integer.TYPE);
        method.invoke(obj, objectArray);
    }
}
