/*
 * Decompiled with CFR 0.152.
 */
import java.text.MessageFormat;

public class NumberFormatterTest {
    public static void main(String[] stringArray) {
        String string = "12.5%";
        double d = 0.125;
        String string2 = MessageFormat.format("{0,number,#,##0.0##%}", d);
        assert (string.equals(string2)) : string2 + " should be formatted as " + string;
    }
}
