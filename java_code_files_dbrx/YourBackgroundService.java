public class Service {
    public static final int START_STICKY = 1;
}

public class Intent {
}

public class YourBackgroundService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO: Start your work here or use a thread
        return START_STICKY;
    }

    public static void main(String[] args) {
    }
}