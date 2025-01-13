/*
 * Decompiled with CFR 0.152.
 */
public class SQLInjection {
    public String executeQuery(String string, String string2) {
        String string3 = "SELECT * FROM users WHERE username = '" + string + "' AND password = '" + string2 + "'";
        return string3;
    }

    public static void main(String[] stringArray) {
        SQLInjection sQLInjection = new SQLInjection();
        String string = "test";
        String string2 = "test";
        System.out.println(sQLInjection.executeQuery(string, string2));
    }
}
