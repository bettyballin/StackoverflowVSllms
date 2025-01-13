/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RunnableFactory {
    public static void main(String[] stringArray) {
        try {
            Class<?> clazz = Class.forName("java.lang.Runnable");
            Class<?> clazz2 = Class.forName("java.lang.Thread");
            Constructor<?> constructor = clazz2.getConstructor(new Class[0]);
            Runnable runnable = (Runnable)constructor.newInstance(new Object[0]);
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {
            System.out.println("An error occurred: " + reflectiveOperationException.getMessage());
        }
    }
}
