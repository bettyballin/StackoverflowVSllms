/*
 * Decompiled with CFR 0.152.
 */
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main_46 {
    public static void main(String[] stringArray) {
        Date date = new Date();
        Date date2 = new Date();
        long l = date2.getTime() - date.getTime();
        long l2 = TimeUnit.MINUTES.convert(l, TimeUnit.MILLISECONDS);
        System.out.println("duration = " + l2);
    }
}
