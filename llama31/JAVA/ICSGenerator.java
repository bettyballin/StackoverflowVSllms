import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ICSGenerator {
    public static void main(String[] args) throws IOException {
        List<Event> events = new ArrayList<>();

        // Add events to the list
        events.add(new Event("Event 1", "2023-03-01T14:00:00", "2023-03-01T15:00:00"));
        events.add(new Event("Event 2", "2023-03-02T10:00:00", "2023-03-02T11:00:00"));
        events.add(new Event("Event 3", "2023-03-03T16:00:00", "2023-03-03T17:00:00"));

        // Create the ICS file
        try (FileWriter writer = new FileWriter("events.ics")) {
            writer.write("BEGIN:VCALENDAR\n");
            writer.write("VERSION:2.0\n");
            writer.write("CALSCALE:GREGORIAN\n");

            for (Event event : events) {
                writer.write("BEGIN:VEVENT\n");
                writer.write("SUMMARY:" + event.getSummary() + "\n");
                writer.write("DTSTART:" + event.getStartDate() + "\n");
                writer.write("DTEND:" + event.getEndDate() + "\n");
                writer.write("END:VEVENT\n");
            }

            writer.write("END:VCALENDAR\n");
        }
    }

    public static class Event {
        private String summary;
        private String startDate;
        private String endDate;

        public Event(String summary, String startDate, String endDate) {
            this.summary = summary;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public String getSummary() {
            return summary;
        }

        public String getStartDate() {
            return startDate;
        }

        public String getEndDate() {
            return endDate;
        }
    }
}