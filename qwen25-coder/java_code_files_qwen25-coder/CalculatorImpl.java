import java.util.concurrent.*;

// Simple RPC-like communication using Java RMI
interface Calculator extends java.rmi.Remote {
    int add(int a, int b) throws java.rmi.RemoteException;
}

class CalculatorImpl implements Calculator {
    public int add(int a, int b) { return a + b; }
}

// Message passing example using threads and queues
class MessagePassingCalculator {
    private final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    void sendAddRequest(int a, int b) {
        try {
            queue.put(a);
            queue.put(b);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    Integer receiveResult() throws InterruptedException {
        return queue.take();
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> queue) { this.queue = queue; }

    @Override
    public void run() {
        while (true) {
            try {
                int a = queue.take();
                int b = queue.take();
                System.out.println(a + b); // Process result
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}