/*
 * Decompiled with CFR 0.152.
 */
import java.util.logging.Level;
import java.util.logging.Logger;

public class SmsReceiver {
    public SmsReceiver() {
        try {
            System.out.println("Simulating SMS connection registration...");
        }
        catch (Exception exception) {
            Logger.getLogger(SmsReceiver.class.getName()).log(Level.SEVERE, "Error registering SMS connection: " + exception.getMessage());
        }
    }

    public void notifyIncomingMessage(Object object) {
        System.out.println("Simulating handling of incoming message...");
    }

    public static void main(String[] stringArray) {
        SmsReceiver smsReceiver = new SmsReceiver();
        smsReceiver.notifyIncomingMessage(null);
    }
}
