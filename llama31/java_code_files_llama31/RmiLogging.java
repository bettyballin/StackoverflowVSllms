/*
 * Decompiled with CFR 0.152.
 */
import java.util.logging.Level;
import java.util.logging.Logger;

public class RmiLogging {
    public static void main(String[] stringArray) {
        System.setProperty("java.rmi.server.logCalls", "true");
        Logger.getLogger("sun.rmi").setLevel(Level.ALL);
    }
}
