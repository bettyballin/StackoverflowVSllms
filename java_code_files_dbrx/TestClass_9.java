import java.util.concurrent.atomic.AtomicInteger;

public class TestClass_9 {
    class TestClass {
       AtomicInteger sharedVar = new AtomicInteger(0); // Shared variable between threads
    
       void incrementMethod(){
           try{
               Thread.sleep(100); // Simulating delay, mimics unpredictable execution order scenario.
               sharedVar.incrementAndGet(); // Perform atomic operation on the shared state.
           } catch (InterruptedException ex){
                throw new RuntimeException("Thread interrupted", ex);
           }
       }
    }
    public static void main(String[] args) {
    }
}