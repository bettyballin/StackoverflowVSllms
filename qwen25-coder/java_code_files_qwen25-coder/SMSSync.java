import java.lang.String;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class SMSSync {
    public static void main(String[] args) {
        LocalDateTime localTime = LocalDateTime.now();
        // Adjust for the 5-minute difference
        LocalDateTime adjustedTime = localTime.minus(5, ChronoUnit.MINUTES);
        long epochSeconds = adjustedTime.atZone(ZoneId.systemDefault()).toEpochSecond();

        System.out.println("URL with adjusted time: http://www.smsgateway.com/?login=myusername&password=mypassword&lasttime=" + epochSeconds);
    }
}