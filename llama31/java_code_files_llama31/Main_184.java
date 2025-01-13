/*
 * Decompiled with CFR 0.152.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main_184 {
    public static void main(String[] stringArray) {
        Date date;
        String string = "Aug-6-2009";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-d-yyyy");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = simpleDateFormat.parse(string);
        }
        catch (ParseException parseException) {
            System.out.println("Error parsing date: " + parseException.getMessage());
            return;
        }
        String string2 = simpleDateFormat2.format(date);
        System.out.println(string2);
    }
}
