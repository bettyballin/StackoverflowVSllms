/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Main_730 {
    public static void main(String[] stringArray) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string = simpleDateFormat.format(timestamp);
        System.out.println("Formatted Timestamp: " + string);
    }
}
