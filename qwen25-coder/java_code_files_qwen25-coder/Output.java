import java.lang.String;
import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Output extends Thread {
    private Class<?> testClass;
    private static final ThreadLocal<ByteArrayOutputStream> threadLocalOut = new ThreadLocal<>();
    private static final ThreadLocal<PrintStream> threadLocalPrintStream = new ThreadLocal<>();

    public Output(Class<?> clazz) {
        this.testClass = clazz;
    }

    private Method getMainMethod(Class<?> clazz) throws SecurityException {
        try {
            return clazz.getDeclaredMethod("main", String[].class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private boolean isMainMethod(Method method) {
        return Modifier.isStatic(method.getModifiers()) &&
               method.getReturnType().equals(void.class) &&
               java.lang.reflect.Array.getLength(method.getParameterTypes()) == 1 &&
               method.getParameterTypes()[0].equals(String[].class);
    }

    public void run() {
        Method mainMethod = null;

        if ((mainMethod = getMainMethod(this.testClass)) != null && isMainMethod(mainMethod)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            
            // Store the current System.out and then redirect it
            PrintStream originalOut = System.out;
            PrintStream originalErr = System.err;

            threadLocalPrintStream.set(printStream);
            threadLocalOut.set(byteArrayOutputStream);

            try {
                System.setOut(printStream);
                System.setErr(printStream);

                mainMethod.invoke(null, (Object) new String[0]);
                
                printStream.flush();
                String output = byteArrayOutputStream.toString();
                System.out.println("Captured Output: " + output);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Restore System.out and System.err to their original values
                System.setOut(originalOut);
                System.setErr(originalErr);

                // Clean up ThreadLocals to prevent memory leaks
                threadLocalPrintStream.remove();
                threadLocalOut.remove();
            }
        } else {
            throw new IllegalArgumentException("No static void main(String[] args) method found in provided class.");
        }
    }

    public static void main(String[] args) {
        Output output = new Output(SampleMain.class);
        output.start();
    }
}

class SampleMain {
    public static void main(String[] args) {
        System.out.println("Hello from the SampleMain!");
        System.err.println("This is an error message.");
    }
}