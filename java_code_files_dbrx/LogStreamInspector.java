import java.lang.String;
import java.util.Map;
import java.util.HashMap;
import java.net.InetAddress;
import java.net.UnknownHostException;

class SunLogger extends LogDomain {
    // Empty subclass
}

class LogStream {
    public static Map<String, LogDomain> getLogDomains() {
        Map<String, LogDomain> map = new HashMap<>();
        map.put("default", new SunLogger());
        return map;
    }
}

class LogDomain {
    public RMIConnection _conn = new RMIConnection();
}

class RMIConnection {
    public RMISocket _rmiClientSocket = new RMISocket();
}

class RMISocket {
    public InetAddress getInetAddress() {
        try {
            return InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            return null;
        }
    }
}

public class LogStreamInspector {
    SunLogger logger = (SunLogger) LogStream.getLogDomains().values().iterator().next(); // this gets a log domain from the server - there should only be one
    RMIConnection rmiCon = ((LogDomain)logger)._conn; // rmi connection - can access threadpool, transport etc...
    String clientAddress = rmiCon._rmiClientSocket.getInetAddress().toString(); // gets socket ip address of the remote client

    public static void main(String[] args) {
    }
}