import java.lang.String;
class PreviewTask implements Runnable{
    // define constructor to get required parameters for the task.
    public void run(){
        // call legacy method here
    }
}

public class MainClass_21 {
   public static void main(String[] args) {
      Thread newThread = new Thread(new PreviewTask ());     // Create a new thread object
      newThread.start();                                // Call start() method
   }
}