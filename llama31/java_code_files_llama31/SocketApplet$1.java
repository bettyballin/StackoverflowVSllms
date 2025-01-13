/*
 * Decompiled with CFR 0.152.
 */
import java.net.Socket;
import java.security.PrivilegedAction;

class SocketApplet.1
implements PrivilegedAction<Void> {
    SocketApplet.1(SocketApplet socketApplet) {
    }

    @Override
    public Void run() {
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
        }
        catch (Exception exception) {
            // empty catch block
        }
        return null;
    }
}
