public class MainLooperHandler {

    public MainLooperHandler() {
        Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                // Your code here
            }
        };
        handler.sendEmptyMessage(0);
    }

    public static void main(String[] args) {
        new MainLooperHandler();
    }
}

class Handler {
    public Handler(Looper looper) {
    }

    public void handleMessage(Message msg) {
    }

    public void sendEmptyMessage(int what) {
    }
}

class Looper {
    public static Looper getMainLooper() {
        return new Looper();
    }
}

class Message {
}

@interface NonNull {
}