/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ICSGenerator {
    public static void main(String[] stringArray) throws IOException {
        ArrayList<Event> arrayList = new ArrayList<Event>();
        arrayList.add(new Event("Event 1", "2023-03-01T14:00:00", "2023-03-01T15:00:00"));
        arrayList.add(new Event("Event 2", "2023-03-02T10:00:00", "2023-03-02T11:00:00"));
        arrayList.add(new Event("Event 3", "2023-03-03T16:00:00", "2023-03-03T17:00:00"));
        try (FileWriter fileWriter = new FileWriter("events.ics");){
            fileWriter.write("BEGIN:VCALENDAR\n");
            fileWriter.write("VERSION:2.0\n");
            fileWriter.write("CALSCALE:GREGORIAN\n");
            for (Event event : arrayList) {
                fileWriter.write("BEGIN:VEVENT\n");
                fileWriter.write("SUMMARY:" + event.getSummary() + "\n");
                fileWriter.write("DTSTART:" + event.getStartDate() + "\n");
                fileWriter.write("DTEND:" + event.getEndDate() + "\n");
                fileWriter.write("END:VEVENT\n");
            }
            fileWriter.write("END:VCALENDAR\n");
        }
    }

    public static class Event {
        private String summary;
        private String startDate;
        private String endDate;

        public Event(String string, String string2, String string3) {
            this.summary = string;
            this.startDate = string2;
            this.endDate = string3;
        }

        public String getSummary() {
            return this.summary;
        }

        public String getStartDate() {
            return this.startDate;
        }

        public String getEndDate() {
            return this.endDate;
        }
    }
}
