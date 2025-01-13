import java.io.File;
import java.lang.String;

public class TurnOnDebuggerException extends Exception {}

public class DebuggerPoller implements Runnable {
    private File triggerFile;

    public DebuggerPoller(File triggerFile) {
        this.triggerFile = triggerFile;
    }

    public void run() {
        while (true) {
            if (triggerFile.exists()) {
                try {
                    throw new TurnOnDebuggerException();
                } catch (TurnOnDebuggerException e) {
                    // Start the debugger
                }
            }
            try {
                Thread.sleep(1000); // poll every 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        File triggerFile = new File("trigger.txt");
        DebuggerPoller poller = new DebuggerPoller(triggerFile);
        Thread thread = new Thread(poller);
        thread.start();
    }
}