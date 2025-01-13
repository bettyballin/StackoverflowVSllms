import java.lang.String;

public class VMChecker {
    public static void main(String[] args) {
        if (System.getProperty("java.vm.name").equals("Dalvik")) {
            // You are running on Dalvik VM
            System.out.println("You are running on Dalvik VM");
        } else {
            // You are running on a different VM
            System.out.println("You are running on a different VM");
        }
    }
}