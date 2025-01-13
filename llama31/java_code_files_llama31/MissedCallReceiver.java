/*
 * Decompiled with CFR 0.152.
 */
public class MissedCallReceiver {
    public void onReceive(String string) {
        System.out.println("Sending email...");
        System.out.println("To: your_email@example.com");
        System.out.println("Subject: Missed Call");
        System.out.println("Body: Missed call from " + string);
        System.out.println("Sending SMS...");
        System.out.println("To: " + string);
        System.out.println("Message: Custom response message");
    }

    public static void main(String[] stringArray) {
        MissedCallReceiver missedCallReceiver = new MissedCallReceiver();
        missedCallReceiver.onReceive("+1234567890");
    }
}
