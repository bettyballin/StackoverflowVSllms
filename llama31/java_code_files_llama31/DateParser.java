/*
 * Decompiled with CFR 0.152.
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateParser {
    public static void main(String[] stringArray) {
        String string = "2022-07-25T14:30:00Z";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        LocalDateTime localDateTime = LocalDateTime.parse(string, dateTimeFormatter);
        String string2 = "2022-07-25T14:30:00.000Z";
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime localDateTime2 = LocalDateTime.parse(string2, dateTimeFormatter2);
    }
}
