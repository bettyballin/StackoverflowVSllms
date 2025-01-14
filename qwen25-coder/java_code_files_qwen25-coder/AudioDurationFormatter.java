import java.lang.String;
public class AudioDurationFormatter {
    public static String formatDuration(long millis) {
        int hours = (int) (millis / (1000 * 60 * 60));
        int minutes = (int) ((millis % (1000 * 60 * 60)) / (1000 * 60));
        int seconds = (int) (((millis % (1000 * 60 * 60)) % (1000 * 60)) / 1000);
        
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static void main(String[] args) {
        long durationInMillis = 332000; // Example value
        System.out.println("Duration: " + formatDuration(durationInMillis));
    }
}