/*
 * Decompiled with CFR 0.152.
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainInvoker {
    public static void main(String[] stringArray) {
        try {
            Method method = MainInvoker.class.getMethod("main", String[].class);
            method.invoke(null, new Object[]{new String[0]});
        }
        catch (InvocationTargetException invocationTargetException) {
            System.err.println("Error executing main class: " + invocationTargetException.getCause().getMessage());
        }
        catch (Exception exception) {
            System.err.println("Error executing main class: " + exception.getMessage());
        }
    }
}
