import java.lang.String;
import java.lang.management.*;

public class ChildProcessWatcher extends Thread {
    private ProcessBuilder pb;

    public ChildProcessWatcher(String... command) {
        this.pb = new ProcessBuilder(command);
    }

    @Override
    public void run() {
        RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();
        String name = mxBean.getName(); // pid of the JVM process running our program
        startProcessAndRegisterShutdownHook(name);
    }

    private synchronized void startProcessAndRegisterShutdownHook(String parentPid) {
        try {
            Process p = pb.start();
            registerShutdownHook(p, parentPid);
            int exitVal = p.waitFor();
            System.out.println("Child process exited with " + exitVal);
        } catch (Exception e) {
            throw new RuntimeException("Failed to start or monitor child process", e);
        }
    }

    private void registerShutdownHook(final Process p, final String parentPid) {
        // This Shutdown-hook will ensure that the child process is killed upon JVM shutdown
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    if (p != null && p.isAlive()) { // Make sure we still need to kill it...
                        osKillProcessAndChildren(Long.parseLong(parentPid));
                    }
                } catch(Exception e) { /* Ignore */ } finally {
                    try { p.destroy(); } catch (Exception ignore) {}
                }
            }
        });
    }

    private void osKillProcessAndChildren(long pid) {
        // Implementation to kill the process and its children
    }

    public static void main(String[] args) {
    }
}