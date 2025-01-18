import java.lang.String;

public class ChildProcessWatcherMain {
    public static void main(String[] args) {
        new ChildProcessWatcher("<child_process>").start();
    }
}

class ChildProcessWatcher {
    private String processName;

    public ChildProcessWatcher(String processName) {
        this.processName = processName;
    }

    public void start() {
        // Placeholder for starting the child process
        System.out.println("Starting child process: " + processName);
    }
}