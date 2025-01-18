public class DayOfWeekCalculator {
    public static void main(String[] args) {
        int uDay = 0; // The bitmask of weekdays
        int today = 1; // Today's day number (Sunday=1, ..., Saturday=7)

        int daysOfWeek = uDay; // The bitmask of weekdays
        int nextDay = (today % 7) + 1; // Assuming that today represents the day number (Sunday=1, ... Saturday=7)
        while ((daysOfWeek & (1 << (nextDay - 1))) == 0 && (nextDay != today)) {
            if (nextDay == 7) {
                nextDay = 1; // Reset to Sunday if nextDay exceeds Saturday
            } else {
                nextDay++;
            }
        }
    }
}