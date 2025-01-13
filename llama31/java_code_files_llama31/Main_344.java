/*
 * Decompiled with CFR 0.152.
 */
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main_344 {
    public static void main(String[] stringArray) {
        String string = "2022-01-01 12:00:00";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(string, dateTimeFormatter);
        long l = localDateTime.atZone(ZoneId.of("UTC")).toInstant().getEpochSecond();
        System.out.println(l);
    }
}
