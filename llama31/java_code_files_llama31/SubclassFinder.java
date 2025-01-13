/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SubclassFinder {
    public static List<Class<?>> getSubclasses(Class<?> clazz) {
        ArrayList arrayList = new ArrayList();
        try {
            Class[] classArray;
            Class<?> clazz2 = Class.forName("java.lang.ClassLoader");
            Method method = clazz2.getDeclaredMethod("getAllLoadedClasses", new Class[0]);
            method.setAccessible(true);
            for (Class clazz3 : classArray = (Class[])method.invoke((Object)clazz.getClassLoader(), new Object[0])) {
                if (!clazz.isAssignableFrom(clazz3) || clazz.equals(clazz3)) continue;
                arrayList.add(clazz3);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return arrayList;
    }

    public static void main(String[] stringArray) {
    }
}
