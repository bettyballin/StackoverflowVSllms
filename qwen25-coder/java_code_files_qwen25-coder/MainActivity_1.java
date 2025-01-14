import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainActivity_1 {

    private static final int MSG_RECORD_START = 1;

    private class Message {
        int what;
        public Message(int what) {
            this.what = what;
        }
    }

    private BlockingQueue<Message> messageQueue = new LinkedBlockingQueue<>();

    private Thread handlerThread;

    public MainActivity_1() {
        // Start the handler thread
        handlerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Message msg = messageQueue.take();
                        handleMessage(msg);
                    }
                } catch (InterruptedException e) {
                    // Thread interrupted
                }
            }
        });
        handlerThread.start();
    }

    private void handleMessage(Message msg) {
        if (msg.what == MSG_RECORD_START) {
            onRecordStart();
        }
    }

    // Simulate onCreate method
    private void onCreate() {
        // Simulate setting up a Button and its OnClickListener
        // Since we don't have UI elements, this can be left empty
    }

    private void recordStart() {
        // Post a message to the handler
        messageQueue.offer(new Message(MSG_RECORD_START));
    }

    private void onRecordStart() {
        // Your logic here, e.g., set geo location info
        setGeoLocationInfo();
    }

    private void setGeoLocationInfo() {
        // Example method to simulate setting geo location
        System.out.println("Geo location info set.");
    }

    public static void main(String[] args) {
        MainActivity_1 app = new MainActivity_1();
        app.onCreate();
        // Simulate button click
        app.recordStart();

        // Allow some time for the handler to process the message
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        // Stop the handler thread
        app.handlerThread.interrupt();
    }
}