import java.lang.String;

public class DBConnectionCloser {

    static OraConn oraConn;
    static Prepare prepare;

    static {
        if (oraConn != null) oraConn.close(prepare);
    }

    public static void main(String[] args) {
    }
}

class OraConn {
    public void close(Prepare prepare) {
        // Implementation
    }
}

class Prepare {
    // Implementation
}