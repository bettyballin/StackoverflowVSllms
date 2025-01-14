import java.lang.String;
import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.InetSocketAddress;

// Define the IBinder interface
interface IBinder {
}

// Define the Intent class
class Intent {
}

// Define the Log class with the static method e
class Log {
    public static void e(String tag, String message, Exception e) {
        System.err.println(tag + ": " + message);
        e.printStackTrace();
    }
}

// Define a base class for Service to extend
class BaseService {
    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onLowMemory() {
    }
}

// Define the Service class
class Service extends BaseService {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}

// The TCPClientService class
public class TCPClientService extends Service {
    private LinkedList<String> Measurements;
    private Thread SendDataThread;
    private volatile boolean shouldRun = true;
    private String serverAddress = "localhost";
    private int portNumber = 12345;
    private boolean connectionAvailable = false;

    @Override
    public void onCreate() {
        super.onCreate();
        Measurements = new LinkedList<>();
        enableDataSending();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLowMemory() {
        Measurements.clear();
        super.onLowMemory();
    }

    @Override
    public void onDestroy() {
        Measurements.clear();
        shouldRun = false; // Signal the thread to stop
        if (SendDataThread != null) {
            SendDataThread.interrupt(); // Interrupt the thread if it's sleeping or blocked
        }
        super.onDestroy();
    }

    private Runnable backgrounSendData = new Runnable() {

        public void run() {
            doSendData();
        }
    };

    private void enableDataSending() {
        if (SendDataThread == null || !SendDataThread.isAlive()) { // Check if the thread is already running
            SendDataThread = new Thread(null, backgrounSendData, "send_data");
            SendDataThread.start();
        }
    }

    private void doSendData() {
        while (shouldRun) { // Use the flag to control the loop
            try {
                if (Measurements.isEmpty()) {
                    Thread.sleep(1000);
                    continue;
                }
                Socket socket = new Socket();
                socket.setTcpNoDelay(true);
                socket.connect(new InetSocketAddress(serverAddress, portNumber), 3000);
                if (!socket.isConnected()) {
                    throw new Exception("Server Unavailable!");
                }
                try {
                    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                    String message = Measurements.remove();
                    out.println(message);
                    Thread.sleep(200);
                    connectionAvailable = true;
                } catch (Exception e) {
                    Log.e("TCP", "S: Error", e);
                    connectionAvailable = false;
                } finally {
                    socket.close();
                    announceNetworkAvailability(connectionAvailable);
                }
            } catch (Exception e) {
                Log.e("TCP", "C: Error", e);
                connectionAvailable = false;
                announceNetworkAvailability(connectionAvailable);
            }
        }
    }

    private void announceNetworkAvailability(boolean available) {
        // Implementation can be empty or provide logging
        System.out.println("Network availability: " + available);
    }

    // Other methods remain unchanged

    public static void main(String[] args) {
        // Entry point of the application
    }
}