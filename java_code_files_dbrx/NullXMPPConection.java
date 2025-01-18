import java.lang.String;

interface XMPPConnection {
    boolean isConnected();
}

public class NullXMPPConection implements XMPPConnection {
    private String host;
    // add additional properties and their getters/setters here as needed

    public NullXMPPConection(String host) {
        this.host = "null";
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    public static void main(String[] args) {
    }
}