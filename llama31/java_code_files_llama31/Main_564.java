/*
 * Decompiled with CFR 0.152.
 */
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main_564 {
    public static void main(String[] stringArray) {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = localDate.atStartOfDay();
        System.out.println(localDateTime);
    }
}
