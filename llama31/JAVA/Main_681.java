import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class Main_681 {
    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle methodHandle = lookup.findStatic(Main.class, "myMethod", MethodType.methodType(void.class, String[].class));
        String[] myArray = new String[] {"Hello", "World"};
        methodHandle.invokeExact(myArray);
    }

    public static void myMethod(String[] arr) {
        for (String str : arr) {
            System.out.println(str);
        }
    }
}