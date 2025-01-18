import java.lang.String;
import java.lang.management.*;

public class Main_80 {
    public static void main(String[] args) {
        System.out.println("Pid is:" + ManagementFactory.getRuntimeMXBean().getName());
    }
}