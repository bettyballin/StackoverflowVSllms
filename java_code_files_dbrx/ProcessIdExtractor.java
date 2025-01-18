import java.lang.String;
import java.lang.management.ManagementFactory;

public class ProcessIdExtractor {
    long pid = Long.parseLong(ManagementFactory.getRuntimeMXBean().getName().split("@")[0].trim().split("-")[1]);
    {
        System.out.println(pid);
    }
    public static void main(String[] args) {
    }
}