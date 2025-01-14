import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.Instant;
import java.time.ZoneId;
import java.time.LocalDate;

public class GroupUTCDateByDay {
    public static void main(String[] args) {
        List<Long> utcDates = List.of(1672531200L, 1672617600L, 1672617601L); // Example UTC timestamps
        Map<LocalDate, List<Long>> groupedByDay = new HashMap<>();

        for (Long utcDate : utcDates) {
            LocalDate localDate = Instant.ofEpochSecond(utcDate).atZone(ZoneId.of("UTC")).toLocalDate();
            groupedByDay.computeIfAbsent(localDate, k -> new ArrayList<>()).add(utcDate);
        }

        System.out.println(groupedByDay);
    }
}