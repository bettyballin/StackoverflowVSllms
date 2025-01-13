/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator_3 {
    public static boolean isValidDate(String string, String string2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string2);
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(string);
            return true;
        }
        catch (ParseException parseException) {
            return false;
        }
    }

    public static void main(String[] stringArray) {
        String string = "2008-06-31";
        String string2 = "yyyy-MM-dd";
        if (DateValidator_3.isValidDate(string, string2)) {
            Timestamp timestamp = Timestamp.valueOf(string + " 23:59:59.000");
            System.out.println(timestamp);
        } else {
            System.out.println("Invalid date");
        }
    }
}
