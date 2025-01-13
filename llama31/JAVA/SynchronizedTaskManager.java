import java.util.concurrent.Semaphore;

public class SynchronizedTaskManager {
    Semaphore sem = new Semaphore(1);

    public void taskA() {
        try {
            sem.acquire();
            // manipulate varX
        } finally {
            sem.release();
        }
    }

    public void taskB() {
        try {
            sem.acquire();
            // manipulate varX
        } finally {
            sem.release();
        }
    }

    public static void main(String[] args) {
        SynchronizedTaskManager manager = new SynchronizedTaskManager();
        manager.taskA();
        manager.taskB();
    }
}