/*
 * Decompiled with CFR 0.152.
 */
public class DatabaseConfigReader {
    String dbUrl = System.getenv("DB_URL");
    String dbUsername = System.getenv("DB_USERNAME");
    String dbPassword = System.getenv("DB_PASSWORD");

    public static void main(String[] stringArray) {
        DatabaseConfigReader databaseConfigReader = new DatabaseConfigReader();
        System.out.println("DB URL: " + databaseConfigReader.dbUrl);
        System.out.println("DB Username: " + databaseConfigReader.dbUsername);
        System.out.println("DB Password: " + databaseConfigReader.dbPassword);
    }
}
