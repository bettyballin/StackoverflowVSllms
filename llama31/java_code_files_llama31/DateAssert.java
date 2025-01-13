/*
 * Decompiled with CFR 0.152.
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAssert {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date expectedDate = new Date();
    Date actualDate = new Date();

    public static void main(String[] stringArray) {
        DateAssert dateAssert = new DateAssert();
        dateAssert.testDateAssert();
    }

    public void testDateAssert() {
        DateAssert.assertEquals(this.sdf.format(this.expectedDate), this.sdf.format(this.actualDate));
    }

    public static void assertEquals(String string, String string2) {
        if (!string.equals(string2)) {
            throw new AssertionError((Object)("Expected: " + string + " but was: " + string2));
        }
    }
}
