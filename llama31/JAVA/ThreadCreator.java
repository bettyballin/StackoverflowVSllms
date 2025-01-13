import java.lang.String;

public class ThreadCreator {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                // Thread code here
            }
        });
        thread.setName("MyThread");
        thread.start();
    }
}