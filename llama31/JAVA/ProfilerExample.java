import org.netbeans.lib.profiler.Profiler;
import org.netbeans.lib.profiler.ProfilerSession;
import org.netbeans.lib.profiler.ProfilerSessionListener;
import org.netbeans.lib.profiler.results.CPUResultsSnapshot;
import org.netbeans.lib.profiler.results.MethodInfo;

public class ProfilerExample {
    public static void main(String[] args) {
        // Create a new profiler session
        ProfilerSession session = Profiler.createSession("My Profiler Session");

        // Add a listener to receive notifications about profiling events
        session.addListener(new ProfilerSessionListener() {
            @Override
            public void profilingStateChanged(ProfilerSession session, int newState) {
                if (newState == ProfilerSession.PROFILING_STATE_RUNNING) {
                    System.out.println("Profiling started");
                } else if (newState == ProfilerSession.PROFILING_STATE_STOPPED) {
                    System.out.println("Profiling stopped");
                }
            }
        });

        // Start profiling
        session.startProfiling();

        // Run the code you want to profile
        // For example, let's profile a simple loop
        for (int i = 0; i < 1000000; i++) {
            doSomeWork();
        }

        // Take a snapshot of the profiling results
        CPUResultsSnapshot snapshot = session.takeCPUResultsSnapshot();

        // Get the hot methods
        MethodInfo[] hotMethods = snapshot.getHotMethods(10); // Get the top 10 hot methods

        // Print the hot methods
        System.out.println("Hot Methods:");
        for (MethodInfo method : hotMethods) {
            System.out.println(method.getMethodName() + " - " + method.getTotalTime());
        }

        // Get the CPU usage
        double cpuUsage = snapshot.getCPUUsage();

        // Print the CPU usage
        System.out.println("CPU Usage: " + cpuUsage + "%");

        // Stop profiling
        session.stopProfiling();
    }

    private static void doSomeWork() {
        // Simulate some work
        for (int i = 0; i < 1000; i++) {
            Math.sin(Math.random());
        }
    }
}