import java.lang.String;

public class MyService_7 extends Service {
    private Messenger mClient = null;

    @Override
    public IBinder onBind(Intent intent) {
        if (intent != null && intent.getExtras() != null) {
            mClient = (Messenger) intent.getExtras().get("MESSENGER");
        }

        return mMessenger.getBinder();
    }

    // Here's your actual Messenger object bound to the service handler.
    private final Messenger mMessenger = new Messenger(new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    processSomeTaskAndSendMessage(msg.replyTo, "Result");
                    break;
                default:
                    super.handleMessage(msg);
            }
        }

        private void processSomeTaskAndSendMessage(Messenger replyTo, String result) {
            // Perform background task and then send the results to replyTo
            Message response = new Message();
            Bundle data = new Bundle();
            data.putString("key", result);  // Put data in response.bundle
            response.what = 1;
            response.setData(data);
            try {
                replyTo.send(response); // send it back to activity via Messenger
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    });

    public static void main(String[] args) {
    }
}

// Minimal stub implementations to make the code compile
class Service {
    public IBinder onBind(Intent intent) {
        return null;
    }
}

interface IBinder {
}

class Intent {
    public Bundle getExtras() {
        return new Bundle();
    }
}

class Messenger {
    public Messenger(Handler handler) {
    }

    public IBinder getBinder() {
        return null;
    }

    public void send(Message message) throws RemoteException {
    }
}

class Handler {
    public Handler() {
    }

    public void handleMessage(Message msg) {
    }
}

class Message {
    public int what;
    public Messenger replyTo;
    private Bundle data;

    public void setData(Bundle data) {
        this.data = data;
    }
}

class Bundle {
    public void putString(String key, String value) {
    }

    public Object get(String key) {
        return null;
    }
}

class RemoteException extends Exception {
}