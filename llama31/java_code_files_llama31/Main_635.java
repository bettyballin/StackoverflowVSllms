/*
 * Decompiled with CFR 0.152.
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main_635 {
    public static void main(String[] stringArray) {
        int n = 2023;
        int n2 = 1;
        int n3 = 1;
        int n4 = 12;
        int n5 = 30;
        LocalDateTime localDateTime = LocalDateTime.of(n, n2, n3, n4, n5);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String string = localDateTime.format(dateTimeFormatter);
        System.out.println(string);
    }
}
