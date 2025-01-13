import java.lang.String;

public class MissedCallReceiver {
    public void onReceive(String phoneNumber) {
        // Send an email with the phone number (using a fictional email sender)
        System.out.println("Sending email...");
        System.out.println("To: your_email@example.com");
        System.out.println("Subject: Missed Call");
        System.out.println("Body: Missed call from " + phoneNumber);

        // Alternatively, customize the SMS auto-response
        System.out.println("Sending SMS...");
        System.out.println("To: " + phoneNumber);
        System.out.println("Message: Custom response message");
    }

    public static void main(String[] args) {
        MissedCallReceiver receiver = new MissedCallReceiver();
        receiver.onReceive("+1234567890");
    }
}