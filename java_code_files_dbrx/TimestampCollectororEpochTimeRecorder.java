import java.lang.String;
import java.util.ArrayList;
import java.time.Instant;

public class TimestampCollectororEpochTimeRecorder {
    static ArrayList<Long> timestamps = new ArrayList<>();

    public static void main(String[] args) {
        timestamps.add(System.currentTimeMillis());
        // or
        timestamps.add(Instant.now().toEpochMilli());
    }
}