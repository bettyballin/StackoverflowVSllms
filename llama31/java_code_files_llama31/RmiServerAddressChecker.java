/*
 * Decompiled with CFR 0.152.
 */
public class RmiServerAddressChecker {
    public static void main(String[] stringArray) {
        String string = System.getProperty("rmi.server.address");
        if (string == null || string.isEmpty()) {
            System.err.println("RMI server address is not provided.");
            System.exit(1);
        }
    }
}
