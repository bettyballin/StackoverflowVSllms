import java.lang.String;

public class DateRangeChecker {

    public static boolean isInRange(int inputDate, int startDate, int endDate) {
        // Convert dates to a comparable format (minutes since Sunday 00:00)
        int inputMinutes = convertDateToMinutes(inputDate);
        int startMinutes = convertDateToMinutes(startDate);
        int endMinutes = convertDateToMinutes(endDate);

        // Check if end date is before start date (wraps around the week)
        if (endMinutes < startMinutes) {
            endMinutes += 7 * 24 * 60; // Add a week's worth of minutes
        }

        // Check if input date is within the range
        return inputMinutes >= startMinutes && inputMinutes <= endMinutes;
    }

    private static int convertDateToMinutes(int date) {
        int day = date / 10000;
        int hour = (date % 10000) / 100;
        int minute = date % 100;

        // Convert day to minutes since Sunday 00:00
        int dayMinutes = (day - 1) * 24 * 60;

        // Add hour and minute components
        return dayMinutes + hour * 60 + minute;
    }

    public static void main(String[] args) {
    }
}