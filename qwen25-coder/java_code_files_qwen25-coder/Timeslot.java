import java.util.HashMap;
import java.util.Map;

public class Timeslot {
    String timeslotId; // e.g., "9:00"
    Map<String, DaySchedule> daySlots; // Maps day names (e.g., "Monday") to the number of slots left

    public Timeslot(String timeslotId) {
        this.timeslotId = timeslotId;
        this.daySlots = new HashMap<>();
    }

    public void addSlot(String day, int numberOfSlots) {
        daySlots.put(day, new DaySchedule(numberOfSlots));
    }

    // Other methods to manipulate and access data...

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}

class DaySchedule {
    int slotsLeft;

    public DaySchedule(int slotsLeft) {
        this.slotsLeft = slotsLeft;
    }

    // Methods to update or query the number of slots...
}