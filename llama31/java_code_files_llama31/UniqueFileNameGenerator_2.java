/*
 * Decompiled with CFR 0.152.
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class UniqueFileNameGenerator_2 {
    private static long counter = 0L;
    private static final Object lock = new Object();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String generateFileName(String string, String string2) {
        Object object = lock;
        synchronized (object) {
            String string3 = dateFormat.format(new Date());
            return string + string3 + "_" + counter++ + string2;
        }
    }

    public static void main(String[] stringArray) {
        String string = UniqueFileNameGenerator_2.generateFileName("file_", ".txt");
        System.out.println(string);
    }
}
