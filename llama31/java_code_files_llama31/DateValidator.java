/*
 * Decompiled with CFR 0.152.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator {
    public boolean isDate(String string) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.parse(string);
        }
        catch (ParseException parseException) {
            return false;
        }
        return true;
    }

    public static void main(String[] stringArray) {
        DateValidator dateValidator = new DateValidator();
        System.out.println(dateValidator.isDate("2022-01-01 12:00:00"));
        System.out.println(dateValidator.isDate("invalid date"));
    }
}
