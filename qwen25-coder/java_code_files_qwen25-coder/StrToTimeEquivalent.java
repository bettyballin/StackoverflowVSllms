import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class StrToTimeEquivalent {
    public static void main(String[] args) throws Exception {
        // Example input strings
        String[] inputs = {
            "2004-02-12T15:19:21+00:00",
            "Thu, 21 Dec 2000 16:01:07 +0200",
            "Monday, January 1st",
            "tomorrow",
            "-1 week 2 days 4 hours 2 seconds"
        };

        for (String input : inputs) {
            Date date = strtotime(input);
            System.out.println("Input: " + input + " -> Output: " + date);
        }
    }

    public static Date strtotime(String input) throws Exception {
        LocalDateTime now = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();

        try {
            // ISO-8601 format with timezone
            if (input.contains("T") && input.contains("+")) {
                return Date.from(ZonedDateTime.parse(input).toInstant());
            }
            // RFC_1123 format (e.g., "Thu, 21 Dec 2000 16:01:07 +0200")
            else if (input.matches("^[A-Za-z]{3},.*")) {
                ZonedDateTime dateTime = ZonedDateTime.parse(input, DateTimeFormatter.RFC_1123_DATE_TIME);
                return Date.from(dateTime.toInstant());
            }
            // Common date formats
            else if (input.matches(".*\\d{4}-\\d{2}-\\d{2}.*")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd[ HH:mm:ss]");
                LocalDateTime dateTime = LocalDateTime.parse(input, formatter);
                return Date.from(dateTime.atZone(zoneId).toInstant());
            }
            // Day of week format (e.g., "Monday, January 1st")
            else if (input.toLowerCase().matches(".*(monday|tuesday|wednesday|thursday|friday|saturday|sunday).*")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d['st']['nd']['rd']['th']");
                LocalDateTime dateTime = LocalDateTime.parse(input, formatter);
                return Date.from(dateTime.atZone(zoneId).toInstant());
            }
            // Relative dates
            else if (input.equalsIgnoreCase("tomorrow")) {
                return Date.from(now.plusDays(1).atStartOfDay(zoneId).toInstant());
            } else {
                LocalDateTime date = now;
                String[] parts = input.split(" ");
                int sign = 1;
                for (String part : parts) {
                    if (part.equals("-")) {
                        sign = -1;
                        continue;
                    }
                    if (part.matches("-?\\d+")) {
                        int value = Integer.parseInt(part) * sign;
                        sign = 1; // reset sign
                        continue;
                    }
                    int value = Integer.parseInt(part.replaceAll("[^\\d-]", "")) * sign;
                    String unit = part.replaceAll("[^A-Za-z]", "").toLowerCase();
                    switch (unit) {
                        case "second":
                        case "seconds":
                            date = date.minusSeconds(value);
                            break;
                        case "minute":
                        case "minutes":
                            date = date.minusMinutes(value);
                            break;
                        case "hour":
                        case "hours":
                            date = date.minusHours(value);
                            break;
                        case "day":
                        case "days":
                            date = date.minusDays(value);
                            break;
                        case "week":
                        case "weeks":
                            date = date.minusWeeks(value);
                            break;
                    }
                    sign = 1; // reset sign after use
                }
                return Date.from(date.atZone(zoneId).toInstant());
            }
        } catch (DateTimeParseException e) {
            // Handle parsing exceptions
            throw new Exception("Invalid input format: " + input, e);
        }
    }
}