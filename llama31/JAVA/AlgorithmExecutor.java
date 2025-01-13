import java.lang.String;

public class AlgorithmExecutor {
    public static void main(String[] args) {
        AlgorithmExecutor executor = new AlgorithmExecutor();
        executor.execute();
    }

    private void execute() {
        while (true) {
            for (int i = 0; i < alg.length; i++) {
                if (execPanel[i].isReset()) {
                    alg[i].terminate();
                    createProgram(i);
                    alg[i].start();
                    execPanel[i].unreset();
                }
            }
            try {
                Thread.sleep(100); // adjust the delay as needed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Assuming alg and execPanel are arrays of some type, 
    // you need to declare and initialize them
    private Alg[] alg; // Replace Alg with the actual class name
    private ExecPanel[] execPanel; // Replace ExecPanel with the actual class name

    private void createProgram(int i) {
        // You need to implement this method
    }
}