import java.lang.String;
import java.util.List;
import java.util.ArrayList;

public class YourWorker {

    Process child;
    // ... other fields

    public void startProcess() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("your", "command");
        this.child = pb.start();
    }

    static List<YourWorker> listOfWorkers = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            for (YourWorker yourWorker : listOfWorkers) { // assume you have a way to keep track of the workers
                if (yourWorker.child != null && yourWorker.child.isAlive())  {
                    yourWorker.child.destroy();
                }
            }
        }));
    }

    public static void main(String[] args) {
        // Assume you have a way to keep track of the workers
        // For example, add a worker to the list
        YourWorker worker = new YourWorker();
        listOfWorkers.add(worker);

        try {
            worker.startProcess();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}