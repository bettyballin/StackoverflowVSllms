import java.lang.String;
public class DebugModeChecker {
    public static void main(String[] args) {
        boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;

        if (!isDebug) {
            DoSomething();
        }
    }

    private static void DoSomething() {
        System.out.println("Not in debug mode, doing something...");
    }
}