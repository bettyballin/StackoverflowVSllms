import org.testcontainers.containers.SmtpServerContainer;

public class SmtpServerContainerManager {
    public static void main(String[] args) {
        SmtpServerContainer smtpServer = new SmtpServerContainer("mailhog/mailhog");
        smtpServer.start();
    }
}