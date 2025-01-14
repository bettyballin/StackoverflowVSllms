public class MyActivity extends AppCompatActivity {

    private Messenger mService = null;

    // Handler for incoming messages from service.
    private final Handler mMessengerHandler = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    // Handle message received from Service
                    break;
                default:
                    super.handleMessage(msg);
            }
            return true;
        }
    });

    @Override
    protected void onStart() {
        super.onStart();
        // The activity is binding to the service.
        Intent intent = new Intent(this, MyService.class);
        // Pass the Messenger object to the service through an Intent parameter.
        intent.putExtra("MESSENGER", new Messenger(mMessengerHandler));
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            mService = new Messenger(service);
        }

        public void onServiceDisconnected(ComponentName arg0) {
            mService = null;
        }
    };

    public static void main(String[] args) {
    }
}

// Stub classes to allow compilation without changing functionality

class AppCompatActivity {
    protected void onStart() {
    }
    protected void super_onStart() {
    }
}

class Messenger {
    public Messenger(IBinder binder) {
    }
    public Messenger(Handler handler) {
    }
}

class Handler {
    public static abstract class Callback extends Handler {
        public abstract boolean handleMessage(Message msg);
    }
    public Handler() {
    }
    public Handler(Callback callback) {
    }
    protected void handleMessage(Message msg) {
    }
}

class Message {
    public int what;
}

class Intent {
    public Intent(MyActivity activity, Class<?> cls) {
    }
    public void putExtra(String name, Messenger messenger) {
    }
}

class MyService {
}

class Context {
    public static final int BIND_AUTO_CREATE = 1;
    public void bindService(Intent intent, ServiceConnection connection, int flags) {
    }
}

interface ServiceConnection {
    void onServiceConnected(ComponentName className, IBinder service);
    void onServiceDisconnected(ComponentName name);
}

class ComponentName {
}

interface IBinder {
}