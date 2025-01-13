/*
 * Decompiled with CFR 0.152.
 */
import java.util.Date;

public class SessionCookieSetter {
    public void onSuccess(String string) {
        String string2 = string;
        Date date = new Date(System.currentTimeMillis() + 1209600000L);
        Cookies.setCookie((String)"sid", (String)string2, (Date)date, null, (String)"/", (boolean)false);
    }

    public static void main(String[] stringArray) {
    }
}
