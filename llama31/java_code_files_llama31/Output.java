/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class Output
extends Thread {
    private Class testClass;
    private ThreadLocal<ByteArrayOutputStream> output = new ThreadLocal();

    public Output(Class clazz) {
        this.testClass = clazz;
    }

    private Method getMainMethod(Class clazz) {
        try {
            Method[] methodArray;
            for (Method method : methodArray = clazz.getMethods()) {
                if (!this.isMainMethod(method).booleanValue()) continue;
                return method;
            }
        }
        catch (SecurityException securityException) {
            // empty catch block
        }
        return null;
    }

    private Boolean isMainMethod(Method method) {
        if (!method.getName().equals("main")) {
            return false;
        }
        Class<?>[] classArray = method.getParameterTypes();
        if (classArray.length != 1) {
            return false;
        }
        if (!classArray[0].equals(String[].class)) {
            return false;
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        this.output.set(new ByteArrayOutputStream());
        PrintStream printStream = System.out;
        PrintStream printStream2 = System.err;
        System.setOut(new PrintStream(this.output.get()));
        System.setErr(new PrintStream(this.output.get()));
        Method method = this.getMainMethod(this.testClass);
        if (method == null) {
            System.out.println("No main method found in the given class");
            return;
        }
        try {
            method.invoke(null, new Object[]{new String[0]});
        }
        catch (Exception exception) {
        }
        finally {
            System.setOut(printStream);
            System.setErr(printStream2);
        }
        String string = this.output.get().toString();
        System.out.println(string);
    }

    public static void main(String[] stringArray) {
        Output output = new Output(Output.class);
        output.start();
    }
}
