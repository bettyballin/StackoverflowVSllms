/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main_384 {
    public static void main(String[] stringArray) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat.parse("23/09/2007");
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(timestamp);
    }
}
