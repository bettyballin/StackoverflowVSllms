/*
 * Decompiled with CFR 0.152.
 */
public class DataSenderService {
    private volatile boolean sendDataThreadRunning = true;
    private Runnable backgroundSendData = new Runnable(){

        @Override
        public void run() {
            while (DataSenderService.this.sendDataThreadRunning) {
                DataSenderService.this.doSendData();
            }
        }
    };

    public void onDestroy() {
        Measurements.clear();
        this.sendDataThreadRunning = false;
        Thread thread = new Thread(this.backgroundSendData);
        thread.interrupt();
    }

    public void doSendData() {
    }

    public static void main(String[] stringArray) {
    }

    public static class Measurements {
        public static void clear() {
        }
    }
}
