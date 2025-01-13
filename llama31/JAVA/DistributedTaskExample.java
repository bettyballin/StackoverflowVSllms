import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;

public class DistributedTaskExample {
    public static void main(String[] args) {
        // Create a Hazelcast instance
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        
        // Get an ExecutorService instance
        IExecutorService executorService = hazelcastInstance.getExecutorService("myExecutor");

        // Submit tasks to the executor service
        for (int i = 0; i < 1000; i += 10) {
            int start = i;
            int end = i + 10;
            executorService.submit(new MyTask(start, end));
        }
        
        // Shutdown the Hazelcast instance when done
        hazelcastInstance.shutdown();
    }

    static class MyTask implements Runnable {
        private int start;
        private int end;

        public MyTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            // Process records from start to end
            System.out.println("Processing records from " + start + " to " + end);
        }
    }
}