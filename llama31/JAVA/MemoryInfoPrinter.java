import java.lang.String;

public class MemoryInfoPrinter {
    public static void main(String[] args) {
        System.out.println("Max memory: " + Runtime.getRuntime().maxMemory());
        System.out.println("Free memory: " + Runtime.getRuntime().freeMemory());
    }
}