/*
 * Decompiled with CFR 0.152.
 */
public class WapPushSender {
    public void sendWapPushMessage(String string) {
        byte[] byArray = this.createWapPushData();
        this.sendSmsMessage(byArray, string);
        String string2 = "You have received a new alert. Please open the WAP Push message to view it.";
        this.sendSmsMessage(string2, string);
    }

    public byte[] createWapPushData() {
        return new byte[0];
    }

    public void sendSmsMessage(byte[] byArray, String string) {
    }

    public void sendSmsMessage(String string, String string2) {
    }

    public static void main(String[] stringArray) {
        WapPushSender wapPushSender = new WapPushSender();
        wapPushSender.sendWapPushMessage("destinationAddress");
    }
}
