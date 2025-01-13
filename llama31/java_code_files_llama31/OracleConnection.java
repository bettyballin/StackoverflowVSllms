/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnection {
    public static void main(String[] stringArray) throws Exception {
        System.setProperty("oracle.jdbc.driver.OracleDriver.compatibility", "10g");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL", "username", "password");
    }
}
