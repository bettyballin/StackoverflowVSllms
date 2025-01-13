import java.lang.String;

public class TimeFormatter_1_1 {
    public static String formatDuration(long seconds) {
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long secs = seconds % 60;

        String formatted = String.format("%02d:%02d:%02d", hours, minutes, secs);
        return formatted;
    }

    public static void main(String[] args) {
        System.out.println(formatDuration(3661)); // Example usage
    }
}