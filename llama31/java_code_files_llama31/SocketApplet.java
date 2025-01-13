/*
 * Decompiled with CFR 0.152.
 */
import java.net.Socket;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class SocketApplet {
    public void connectToHost() {
        AccessController.doPrivileged(new PrivilegedAction<Void>(this){

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
        });
    }

    public static void main(String[] stringArray) {
    }
}
