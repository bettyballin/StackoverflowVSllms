import java.lang.String;
public class SleepingThread {
    static {
        try{
            Thread.sleep(10_000);
            process();
        } catch (InterruptedException e){
            //Perform any cleanup operations required.
        }
    }

    public static void main(String[] args) {
    }

    public static void process() {
        // Process method implementation
    }
}