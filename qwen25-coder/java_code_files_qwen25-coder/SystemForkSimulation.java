import java.lang.String;
import java.io.IOException;

public class SystemForkSimulation {
    public static void main(String[] args) {
        try {
            // Run this same program again in a new process
            Runtime.getRuntime().exec("java -cp . ForkSimulation");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}