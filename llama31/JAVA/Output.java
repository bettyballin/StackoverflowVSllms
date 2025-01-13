import java.lang.String;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class Output extends Thread {
    private Class testClass;
    private ThreadLocal<ByteArrayOutputStream> output = new ThreadLocal<>();

    public Output(Class clazz) {
        this.testClass = clazz;
    }

    private Method getMainMethod(Class clazz) {
        try {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (isMainMethod(method)) {
                    return method;
                }
            }
        } catch (SecurityException e) {
            // Handle the exception as needed
        }
        return null;
    }

    private Boolean isMainMethod(Method method) {
        if (!method.getName().equals("main")) {
            return false;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 1) {
            return false;
        }
        if (!parameterTypes[0].equals(String[].class)) {
            return false;
        }
        return true;
    }

    public void run() {
        output.set(new ByteArrayOutputStream());
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;
        System.setOut(new PrintStream(output.get()));
        System.setErr(new PrintStream(output.get()));

        Method mainMethod = getMainMethod(testClass);
        if (mainMethod == null) {
            System.out.println("No main method found in the given class");
            return;
        }

        try {
            mainMethod.invoke(null, new Object[]{new String[0]});
        } catch (Exception e) {
            // Handle the exception as needed
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }

        String capturedOutput = output.get().toString();
        // Process the captured output as needed
        System.out.println(capturedOutput);
    }

    public static void main(String[] args) {
        Output output = new Output(Output.class);
        output.start();
    }
}