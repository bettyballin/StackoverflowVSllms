import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimeSlotConverter {
    public static void main(String[] args) {
        // Sample input data
        List<String> timeSlots = new ArrayList<>();
        timeSlots.add("1200-1300");
        timeSlots.add("1400-1500");
        timeSlots.add("1300-1400");

        // Sort the list based on start time
        Collections.sort(timeSlots);

        // Define a formatter for 12-hour clock format with AM/PM
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("ha");

        // Process each time slot
        for (String timeSlot : timeSlots) {
            String[] parts = timeSlot.split("-");
            LocalTime startTime = LocalTime.parse(parts[0], DateTimeFormatter.ofPattern("Hmm"));
            LocalTime endTime = LocalTime.parse(parts[1], DateTimeFormatter.ofPattern("Hmm"));

            // Convert to 12-hour format and display
            System.out.println(startTime.format(outputFormatter) + " - " + endTime.format(outputFormatter));
        }
    }
}