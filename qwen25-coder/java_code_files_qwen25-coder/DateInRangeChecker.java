public class DateInRangeChecker {
    public boolean isDateInRange(int startDate, int inputDate, int endDate) {
        // Normalize dates to a common starting point (e.g., Sunday at midnight)
        int normalizedInput = normalize(startDate, inputDate);
        int normalizedEnd = normalize(startDate, endDate);
    
        return normalizedInput >= 0 && normalizedInput <= normalizedEnd;
    }
    
    private int normalize(int baseDate, int date) {
        int baseDay = baseDate / 10000 % 10;
        int baseTime = baseDate % 10000;
    
        int day = date / 10000 % 10;
        int time = date % 10000;
    
        // Calculate the difference in days
        int dayDiff = (day - baseDay + 7) % 7;
    
        // If the input date is on a different week, add or subtract 7 to normalize it
        if (time < baseTime && (date + 72359 >= baseDate)) {
            return dayDiff * 1440 + time - baseTime; // subtracting today's time from base time and adding next week's minutes
        } else {
            return dayDiff * 1440 + time;
        }
    
        // Convert to the number of minutes since the start of the week in the same cycle as startDate
    }
    
    // Example usage:
    public static void main(String[] args) {
        int startDate = 21500;  // Monday at 1:50 PM
        int inputDate = 41630;  // Wednesday at 4:30 PM
        int endDate = 10959;   // Sunday at 9:59 AM
    
        DateInRangeChecker checker = new DateInRangeChecker();
        System.out.println(checker.isDateInRange(startDate, inputDate, endDate)); // This should return true
    }
}