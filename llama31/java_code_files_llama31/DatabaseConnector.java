/*
 * Decompiled with CFR 0.152.
 */
public class DatabaseConnector {
    String url = "jdbc:sqlserver://your_host:1433;databaseName=your_database;encrypt=true;trustServerCertificate=true";

    public static void main(String[] stringArray) {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        System.out.println(databaseConnector.url);
    }
}
