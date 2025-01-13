/*
 * Decompiled with CFR 0.152.
 */
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StrToTime {
    public static void main(String[] stringArray) {
        System.out.println(StrToTime.strToTime("2004-02-12T15:19:21+00:00"));
        System.out.println(StrToTime.strToTime("Thu, 21 Dec 2000 16:01:07 +0200"));
        System.out.println(StrToTime.strToTime("Monday, January 1st"));
        System.out.println(StrToTime.strToTime("tomorrow"));
        System.out.println(StrToTime.strToTime("-1 week 2 days 4 hours 2 seconds"));
    }

    public static ZonedDateTime strToTime(String string) {
        try {
            return ZonedDateTime.parse(string, DateTimeFormatter.ISO_DATE_TIME);
        }
        catch (DateTimeParseException dateTimeParseException) {
            try {
                return ZonedDateTime.parse(string, DateTimeFormatter.RFC_1123_DATE_TIME);
            }
            catch (DateTimeParseException dateTimeParseException2) {
                return StrToTime.parseRelativeDate(string);
            }
        }
    }

    private static ZonedDateTime parseRelativeDate(String string) {
        if (string.equalsIgnoreCase("tomorrow")) {
            return ZonedDateTime.now().plusDays(1L);
        }
        if (string.startsWith("-")) {
            String[] stringArray = string.substring(1).split(" ");
            int n = 0;
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            for (String string2 : stringArray) {
                if (string2.endsWith("week")) {
                    n = Integer.parseInt(string2.substring(0, string2.length() - 4));
                    continue;
                }
                if (string2.endsWith("day")) {
                    n2 = Integer.parseInt(string2.substring(0, string2.length() - 3));
                    continue;
                }
                if (string2.endsWith("hour")) {
                    n3 = Integer.parseInt(string2.substring(0, string2.length() - 4));
                    continue;
                }
                if (!string2.endsWith("second")) continue;
                n4 = Integer.parseInt(string2.substring(0, string2.length() - 6));
            }
            return ZonedDateTime.now().minusWeeks(n).minusDays(n2).minusHours(n3).minusSeconds(n4);
        }
        throw new UnsupportedOperationException("Unsupported relative date format");
    }
}
