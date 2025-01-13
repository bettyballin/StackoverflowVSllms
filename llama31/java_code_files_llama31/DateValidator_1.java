/*
 * Decompiled with CFR 0.152.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator_1 {
    public static boolean isValidDate(int n, int n2, int n3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setLenient(false);
        try {
            Date date = simpleDateFormat.parse(String.format("%04d-%02d-%02d", n, n2, n3));
            return true;
        }
        catch (ParseException parseException) {
            return false;
        }
    }

    public static void main(String[] stringArray) {
        System.out.println(DateValidator_1.isValidDate(2008, 2, 31));
        System.out.println(DateValidator_1.isValidDate(2008, 2, 29));
    }
}
