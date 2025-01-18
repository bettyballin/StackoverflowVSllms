import java.lang.String;
import java.util.concurrent.*;

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);

        Thread t = new Thread()
        {
            @Override
            public void run(){
                try{
                    System.out.println("Start of thread execution");
                    Thread.sleep(2000); // pause for 2 sec
                    latch.countDown(); // reduce the count
                    System.out.println("End of thread execution");
                }catch(InterruptedException e){}
            }
        };
        t.start();

        System.out.println("Waiting for completion signal from thread");
        latch.await(); // waits until countDown() method is called at some point in the other threads
        Thread.sleep(100);
        System.exit(0);
    }
}