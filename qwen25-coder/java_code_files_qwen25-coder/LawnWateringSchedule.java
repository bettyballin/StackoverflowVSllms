import java.util.HashMap;
import java.util.Map;

public class LawnWateringSchedule {
    private Map<String, Map<String, String>> schedule;
    private Map<String, int[]> seasons;

    public LawnWateringSchedule() {
        // Initialize the schedules for each group and season
        schedule = new HashMap<String, Map<String, String>>();

        schedule.put("A", new HashMap<String, String>());
        schedule.get("A").put("Winter", "M");
        schedule.get("A").put("Spring", "tTS");
        schedule.get("A").put("Summer", "Any");
        schedule.get("A").put("Fall", "tTS");

        schedule.put("B", new HashMap<String, String>());
        schedule.get("B").put("Winter", "t");
        // Add more groups and their schedules as needed

        // Define the start and end dates for each season
        seasons = new HashMap<String, int[]>();
        seasons.put("Summer", new int[]{501, 831});
        seasons.put("Spring", new int[]{301, 430});
        seasons.put("Fall", new int[]{901, 1031});
        seasons.put("Winter", new int[]{1101, 228}); // Considering non-leap year
    }

    public String getWateringDays(String group, int monthDay) {
        String season = determineSeason(monthDay);
        return schedule.get(group).get(season);
    }

    private String determineSeason(int monthDay) {
        for (Map.Entry<String, int[]> entry : seasons.entrySet()) {
            int start = (entry.getValue())[0];
            int end = (entry.getValue())[1];
            if (start <= end) {
                // Normal range
                if (monthDay >= start && monthDay <= end) {
                    return entry.getKey();
                }
            } else {
                // Range wraps around end of year
                if (monthDay >= start || monthDay <= end) {
                    return entry.getKey();
                }
            }
        }
        throw new IllegalArgumentException("Date is out of defined seasons.");
    }

    public static void main(String[] args) {
        LawnWateringSchedule lawnWateringSchedule = new LawnWateringSchedule();
        int today = 325; // Example for March 25
        String group = "A";
        System.out.println("Allowed watering days: " + lawnWateringSchedule.getWateringDays(group, today));
    }
}