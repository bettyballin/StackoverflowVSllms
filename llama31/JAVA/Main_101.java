import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main_101 {
    // Assuming alg and execPanel are defined somewhere in your code
    private Algorithm[] alg;
    private ExecutionPanel[] execPanel;

    public static void main(String[] args) {
        Main main = new Main();
        main.startScheduler();
    }

    public void startScheduler() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < alg.length; i++) {
                    if (execPanel[i].isReset()) {
                        alg[i].terminate();
                        createProgram(i);
                        alg[i].start();
                        execPanel[i].unreset();
                    }
                }
            }
        }, 0, 100, TimeUnit.MILLISECONDS); // adjust the rate as needed
    }

    // Assuming createProgram is defined somewhere in your code
    private void createProgram(int i) {
        // Add your createProgram logic here
    }
}

// Assuming Algorithm and ExecutionPanel are defined somewhere in your code
class Algorithm {
    public void terminate() {
        // Add your terminate logic here
    }

    public void start() {
        // Add your start logic here
    }
}

class ExecutionPanel {
    public boolean isReset() {
        // Add your isReset logic here
        return false; // default return
    }

    public void unreset() {
        // Add your unreset logic here
    }
}