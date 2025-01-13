import java.lang.instrument.Instrumentation;

public class ObjectSizeCalculator_1 {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object obj) {
        return instrumentation.getObjectSize(obj);
    }

    public static void main(String[] args) {
        Object myObject = new Object(); // the object you want to measure
        long size = ObjectSizeCalculator.getObjectSize(myObject);
        System.out.println("Object size: " + size + " bytes");
    }
}