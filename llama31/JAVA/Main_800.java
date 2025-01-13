import java.lang.String;
public class Main_800 {
    public static void main(String[] args) {
        String name = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
        String pid = name.split("@")[0];
        System.out.println("Process ID: " + pid);
    }
}