import java.util.*;

public class EventBannerLayout {
    public static void main(String[] args) {
        List<Event> events = Arrays.asList(
                new Event(10, 11),
                new Event(11, 15),
                new Event(10, 11),
                new Event(13, 14)
        );
        placeEvents(events);
    }

    static class Event {
        int startDay;
        int endDay;

        public Event(int startDay, int endDay) {
            this.startDay = startDay;
            this.endDay = endDay;
        }
    }

    private static void placeEvents(List<Event> events) {
        // Sort events by start day (and then by end day)
        Collections.sort(events, Comparator.comparingInt((Event e) -> e.startDay).thenComparingInt(e -> e.endDay));

        int maxEndDay = events.stream().mapToInt(e -> e.endDay).max().orElse(0);
        List<Set<Event>> dailyEvents = new ArrayList<>(Collections.nCopies(maxEndDay + 1, new HashSet<Event>()));

        // Populate the map of daily events
        for (Event event : events) {
            for (int day = event.startDay; day <= event.endDay; day++) {
                dailyEvents.get(day).add(event);
            }
        }

        // Track the maximum end day for each event level
        List<Integer> levelsEndDays = new ArrayList<>();
        levelsEndDays.add(0);

        // Place events in the layout
        for (Event event : events) {
            int placedLevel = -1;
            // Try to fit into existing levels
            for (int i = 0; i < levelsEndDays.size() && placedLevel == -1; i++) {
                if (levelsEndDays.get(i) < event.startDay) {
                    placedLevel = i;
                    levelsEndDays.set(placedLevel, event.endDay);
                }
            }
            // If no level fits, add a new level
            if (placedLevel == -1) {
                placedLevel = levelsEndDays.size();
                levelsEndDays.add(event.endDay);
            }

            System.out.println("Place event from " + event.startDay + " to " + event.endDay + " at level " + placedLevel);
        }

        // Output result: print banner layout
        for (int level = 0; level < levelsEndDays.size(); level++) {
            StringBuilder line = new StringBuilder();
            int currentDay = 1;
            while (currentDay <= maxEndDay) {
                boolean hasEventInLevel = dailyEvents.get(currentDay).stream()
                        .anyMatch(e -> events.stream().filter(event -> event.startDay <= currentDay && event.endDay >= currentDay)
                                .mapToInt(evt -> levelsEndDays.indexOf(evt.endDay)).min().orElse(Integer.MAX_VALUE) == level);
                line.append(hasEventInLevel ? "b" : " ");
                currentDay++;
            }
            System.out.println(line.toString());
        }
    }
}