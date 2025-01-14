import java.lang.String;
public class WorkerThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Worker thread");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new WorkerThread()).start();
        }
    }
}