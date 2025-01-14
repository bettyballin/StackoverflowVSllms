import java.lang.String;
public class JazelleCheck {
    public static void main(String[] args) {
        String cpuAbi = System.getProperty("os.arch");
        if ("arm".equals(cpuAbi)) {
            System.out.println("Running on ARM architecture.");
            // Note: Checking for Jazelle is not straightforward from Java code.
            // This would typically require inspecting low-level CPU capabilities,
            // which is beyond the scope of standard Java applications.
        } else {
            System.out.println("Not running on ARM.");
        }
    }
}