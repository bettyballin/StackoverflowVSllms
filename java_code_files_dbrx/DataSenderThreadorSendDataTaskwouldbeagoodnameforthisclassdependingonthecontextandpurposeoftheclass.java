import java.lang.String;
public class DataSenderThreadorSendDataTaskwouldbeagoodnameforthisclassdependingonthecontextandpurposeoftheclass {
    private volatile boolean shouldRun = true; // Add this flag

    private Runnable backgroundSendData = new Runnable() {
        @Override
        public void run() {
            doSendData();
        }
    };

    private Thread SendDataThread;

    private void doSendData() {
        // Implement the data sending logic here
    }

    private void enableDataSending() {
        SendDataThread = new Thread(null, backgroundSendData, "send_data");
        SendDataThread.start();
    }
    public static void main(String[] args) {
    }
}