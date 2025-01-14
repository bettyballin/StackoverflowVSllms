import java.lang.String;
import java.lang.Integer;
public class WeekdayFinder {
    public static int getNextWeekday(int bitmask, int today) {
        // Adjust today to be zero-indexed for bitwise operations (Sunday = 0)
        int adjustedToday = (today - 1) & 7; // Ensure it wraps around correctly

        // Shift the bitmask left by adjustedToday positions
        // and use modulo operation to wrap around the week
        int rotatedBitmask = ((bitmask << adjustedToday) | (bitmask >> (7 - adjustedToday))) & 0x7F;

        // Find the position of the first set bit in the rotated bitmask
        return Integer.numberOfTrailingZeros(rotatedBitmask) + 1; // Convert back to one-indexed day
    }

    public static void main(String[] args) {
        int uDay = 0x03; // Sunday (1) | Monday (2)
        int today = 3;   // Tuesday

        int nextWeekday = getNextWeekday(uDay, today);
        System.out.println("Next weekday: " + nextWeekday); // Output should be 1 for Sunday
    }
}