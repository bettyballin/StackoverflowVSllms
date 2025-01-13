import java.lang.String;
import java.lang.Integer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StrToTime {
    public static void main(String[] args) {
        System.out.println(strToTime("2004-02-12T15:19:21+00:00"));
        System.out.println(strToTime("Thu, 21 Dec 2000 16:01:07 +0200"));
        System.out.println(strToTime("Monday, January 1st"));
        System.out.println(strToTime("tomorrow"));
        System.out.println(strToTime("-1 week 2 days 4 hours 2 seconds"));
    }

    public static ZonedDateTime strToTime(String input) {
        try {
            return ZonedDateTime.parse(input, DateTimeFormatter.ISO_DATE_TIME);
        } catch (DateTimeParseException e) {
            try {
                return ZonedDateTime.parse(input, DateTimeFormatter.RFC_1123_DATE_TIME);
            } catch (DateTimeParseException ex) {
                // Try to parse using a custom formatter for relative dates
                return parseRelativeDate(input);
            }
        }
    }

    private static ZonedDateTime parseRelativeDate(String input) {
        // Implement your own logic for parsing relative dates
        // This is a basic example and may not cover all cases
        if (input.equalsIgnoreCase("tomorrow")) {
            return ZonedDateTime.now().plusDays(1);
        } else if (input.startsWith("-")) {
            String[] parts = input.substring(1).split(" ");
            int weeks = 0, days = 0, hours = 0, seconds = 0;
            for (String part : parts) {
                if (part.endsWith("week")) {
                    weeks = Integer.parseInt(part.substring(0, part.length() - 4));
                } else if (part.endsWith("day")) {
                    days = Integer.parseInt(part.substring(0, part.length() - 3));
                } else if (part.endsWith("hour")) {
                    hours = Integer.parseInt(part.substring(0, part.length() - 4));
                } else if (part.endsWith("second")) {
                    seconds = Integer.parseInt(part.substring(0, part.length() - 6));
                }
            }
            return ZonedDateTime.now().minusWeeks(weeks).minusDays(days).minusHours(hours).minusSeconds(seconds);
        } else {
            // Handle other relative date formats
            throw new UnsupportedOperationException("Unsupported relative date format");
        }
    }
}