/*
 * Decompiled with CFR 0.152.
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main_637 {
    public static void main(String[] stringArray) {
        int n = 2023;
        int n2 = 0;
        int n3 = 1;
        int n4 = 12;
        int n5 = 30;
        Calendar calendar = Calendar.getInstance();
        calendar.set(n, n2, n3, n4, n5);
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        String string = simpleDateFormat.format(date);
        System.out.println(string);
    }
}
