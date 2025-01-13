/*
 * Decompiled with CFR 0.152.
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateExample {
    public static void main(String[] stringArray) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String string = localDate.format(dateTimeFormatter);
        System.out.println(string);
    }
}
