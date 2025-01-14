import java.lang.String;

public class Connection {
    int localPort;
    String remoteIp;
    int remotePort;

    public Connection(int localPort, String remoteIp, int remotePort) {
        this.localPort = localPort;
        this.remoteIp = remoteIp;
        this.remotePort = remotePort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Connection that = (Connection) o;
        return localPort == that.localPort &&
               remotePort == that.remotePort &&
               remoteIp.equals(that.remoteIp);
    }

    @Override
    public int hashCode() {
        int result = localPort;
        result = 31 * result + remoteIp.hashCode();
        result = 31 * result + remotePort;
        return result;
    }

    public static void main(String[] args) {
    }
}