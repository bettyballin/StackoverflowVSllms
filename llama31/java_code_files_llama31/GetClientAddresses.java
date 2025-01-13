/*
 * Decompiled with CFR 0.152.
 */
public class GetClientAddresses {
    public static void main(String[] stringArray) {
        String string = "127.0.0.1";
        String string2 = GetClientAddresses.simulateMACRetrieval(string);
        System.out.println("IP Address: " + string);
        System.out.println("MAC Address: " + string2);
    }

    private static String simulateMACRetrieval(String string) {
        return "00:11:22:33:44:55";
    }
}
