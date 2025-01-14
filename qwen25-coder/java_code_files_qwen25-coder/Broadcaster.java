import java.lang.String;

public class Intent {
    public Intent(String action) {
        // constructor implementation
    }
    public void putExtra(String key, String value) {
        // method implementation
    }
}

public class Broadcaster {
    public static void sendBroadcast(Intent intent) {
        // implementation
    }

    public static void main(String[] args) {
        Intent intent = new Intent("com.example.ACTION_UPDATE_UI");
        intent.putExtra("data", "Some data");
        sendBroadcast(intent);
    }
}