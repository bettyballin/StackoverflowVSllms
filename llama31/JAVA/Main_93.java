public class Main_93 {
    public static void main(String[] args) {
        long durationInSeconds = 332; // Your duration value here
        String formattedDuration = formatDuration(durationInSeconds);
        System.out.println(formattedDuration); // Outputs: 00:05:32
    }

    public static String formatDuration(long seconds) {
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long secs = seconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }
}