import java.lang.String;

public class DataSenderService {
    private volatile boolean sendDataThreadRunning = true;

    private Runnable backgroundSendData = new Runnable() {
        public void run() {
            while (sendDataThreadRunning) {
                doSendData();
            }
        }
    };

    public void onDestroy() {
        Measurements.clear();
        sendDataThreadRunning = false;
        Thread SendDataThread = new Thread(backgroundSendData);
        SendDataThread.interrupt();
    }

    public void doSendData() {
        // implement your data sending logic here
    }

    public static class Measurements {
        public static void clear() {
            // implement your measurements clearing logic here
        }
    }

    public static void main(String[] args) {
    }
}