import java.lang.String;
import java.lang.instrument.Instrumentation;

public class MemoryUsage_1 {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }

    public static void main(String[] args) {
        int number = 42;
        String text = "Hello, world!";
        
        System.out.println("int size: " + getObjectSize(number));
        System.out.println("String size: " + getObjectSize(text));
    }
}