/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

public class Main_73 {
    public static void main(String[] stringArray) {
        long l2 = 1643723400L;
        long l3 = l2 * 1000L;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.setTimeInMillis(l3);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long l4 = calendar.getTimeInMillis();
        HashMap<Long, List> hashMap = new HashMap<Long, List>();
        hashMap.computeIfAbsent(l4, l -> new ArrayList()).add(l2);
        System.out.println(hashMap);
    }
}
