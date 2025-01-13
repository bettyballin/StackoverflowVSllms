/*
 * Decompiled with CFR 0.152.
 */
public class QueryCreator_1 {
    public static String createQuery(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM ").append(string).append(" WHERE ").append(string2).append(" = ?");
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
        String string = "users";
        String string2 = "username";
        String string3 = QueryCreator_1.createQuery(string, string2);
    }
}
