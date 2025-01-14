import java.lang.String;
public class JVMCheck {
    public static void main(String[] args) {
        System.out.println("JVM Bit Type: " + (System.getProperty("sun.arch.data.model")));
    }
}