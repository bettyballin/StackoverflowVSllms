import java.lang.String;
import java.lang.Integer;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class TimeAdder {
    public static void main(String[] args) {
        String initialTime = "13:30";
        String timeToAdd = "02:02:02";

        LocalTime baseTime = LocalTime.parse(initialTime, DateTimeFormatter.ofPattern("HH:mm"));
        Duration durationToAdd = parseDuration(timeToAdd);

        LocalTime resultTime = baseTime.plus(durationToAdd);
        String formattedResult = resultTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        System.out.println(formattedResult); // Output: 15:32:02
    }

    private static Duration parseDuration(String durationString) {
        String[] parts = durationString.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);

        return Duration.ofHours(hours).plusMinutes(minutes).plusSeconds(seconds);
    }
}