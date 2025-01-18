import java.lang.String;
import java.io.*;
import static java.lang.System.out;
import java.lang.reflect.*;

public class Output extends Thread {
    private Class<?> testClass;
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();

    public Output(Class<?> clazz) {
        this.testClass = clazz;
    }

    @Override
    public void run() {
        try {
            PrintStream ps = new PrintStream(baos, true);  //true for auto-flush
            out.println("Capturing output of " + testClass.getSimpleName());
            System.setOut(ps);   //Capture System.out in ps (PrintStream) --> baos
            Method mainMethod = null;

            if ((mainMethod = getMainMethod(testClass)) == null) {   //if there's no static void main method, throw exception
                throw new IllegalStateException();
            }

            mainMethod.invoke(null /*no instance necessary for the invocation */ , (Object[]) null);    //invokes: testClassInstance.main() but we have no instantiated class as it's a static call

            String output = baos.toString();  //Here is your captured/redirected output!
            out.println("Captured Output:\n" + output);   /*Note, System.out has not been restored yet*/
        } catch (Exception e) {
            e.printStackTrace();    //prints to the original System.err; since we have not set up yet to capture it in this example.
        } finally {
           System.setOut(out);   //Restores original Out and also auto-flushes our 'ps' into 'baos'.
           out.println("Capturing output finished for " + testClass.getSimpleName());  //This is printed to the original System.out; not to baos anymore!
        }
    }
    
    private static Method getMainMethod(Class<?> clazz) throws NoSuchMethodException {
        return clazz.getMethod("main", String[].class);
    }
}