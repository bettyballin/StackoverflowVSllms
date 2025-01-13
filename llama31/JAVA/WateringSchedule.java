import java.lang.String;
import java.lang.Map;
import java.lang.HashMap;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class WateringSchedule {
    private enum Season {
        WINTER(Month.NOVEMBER, 1, Month.FEBRUARY, 28),
        SPRING(Month.MARCH, 1, Month.APRIL, 30),
        SUMMER(Month.MAY, 1, Month.AUGUST, 31),
        FALL(Month.SEPTEMBER, 1, Month.OCTOBER, 31);

        private final Month startMonth;
        private final int startDay;
        private final Month endMonth;
        private final int endDay;

        Season(Month startMonth, int startDay, Month endMonth, int endDay) {
            this.startMonth = startMonth;
            this.startDay = startDay;
            this.endMonth = endMonth;
            this.endDay = endDay;
        }

        public boolean isInSeason(LocalDate date) {
            return (date.getMonth() == startMonth && date.getDayOfMonth() >= startDay) ||
                   (date.getMonth() == endMonth && date.getDayOfMonth() <= endDay) ||
                   (date.getMonth().getValue() > startMonth.getValue() && date.getMonth().getValue() < endMonth.getValue());
        }
    }

    private static final Map<String, Map<Season, String>> schedule = new HashMap<>();

    static {
        schedule.put("A", Map.of(
                Season.WINTER, "M",
                Season.SPRING, "tTS",
                Season.SUMMER, "Any",
                Season.FALL, "tTS"
        ));
        // Add more groups as needed
    }

    public static String getAllowedDays(String group, LocalDate date) {
        for (Season season : Season.values()) {
            if (season.isInSeason(date)) {
                return schedule.get(group).get(season);
            }
        }
        return null; // or throw an exception if no matching season is found
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String group = "A";
        System.out.println("Allowed days for group " + group + " on " + date + ": " + getAllowedDays(group, date));
    }
}