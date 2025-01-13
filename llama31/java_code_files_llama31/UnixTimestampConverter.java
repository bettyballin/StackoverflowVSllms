/*
 * Decompiled with CFR 0.152.
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class UnixTimestampConverter {
    public static void main(String[] stringArray) {
        long l = 1251783433L;
        Date date = new Date(l * 1000L);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string = simpleDateFormat.format(date);
        System.out.println(string);
    }
}
