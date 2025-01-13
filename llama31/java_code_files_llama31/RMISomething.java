/*
 * Decompiled with CFR 0.152.
 */
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;

public class RMISomething {
    public static String getSomething() throws ServerNotActiveException {
        return RemoteServer.getClientHost();
    }

    public static void main(String[] stringArray) {
    }
}
