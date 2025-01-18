import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Best practice is for each instance to have its own LUN
        List<String> separateLuns = Arrays.asList("data_Instance1", "log_Instance1", "data_Instance2", "log_Instance2"); // And so on...
        for(String lns : separateLuns) {
            System.out.println("Create and format LUN: " + lns);
        }
    }
}