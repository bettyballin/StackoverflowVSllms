/*
 * Decompiled with CFR 0.152.
 */
public class QueryCreator {
    public static String createQuery(String string, String string2) {
        String string3 = String.format("SELECT * FROM %s WHERE %s = ?", string, string2);
        return string3;
    }

    public static void main(String[] stringArray) {
        String string = "users";
        String string2 = "username";
        String string3 = QueryCreator.createQuery(string, string2);
    }
}
