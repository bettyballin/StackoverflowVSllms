import java.lang.String;

public class EmailRateLimiter {

    int maxEmailsPerMinute = 10;
    long lastSendTime = System.currentTimeMillis();
    EmailSender emailSender;

    public void sendEmail(SimpleMailMessage message) throws InterruptedException {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastSendTime < (60 * 1000 / maxEmailsPerMinute)) {
            Thread.sleep(Math.abs(60 * 1000 / maxEmailsPerMinute - (currentTime - lastSendTime)));
        }
        emailSender.send(message);
        lastSendTime = System.currentTimeMillis();
    }

    public static void main(String[] args) {
    }
}

interface EmailSender {
    void send(SimpleMailMessage message);
}

class SimpleMailMessage {
    // Contents not important for compilation
}