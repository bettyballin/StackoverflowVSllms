import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class LoadJavaIntoOracle {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//your_host:port/service_name";
        String user = "your_user";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String javaSrc =
                "CREATE OR REPLACE JAVA SOURCE NAMED \"test.Test\" AS\n" +
                "package test;\n" +
                "public class Test {\n" +
                "    public static String myMethod(String a) {\n" +
                "        return a;\n" +
                "    }\n" +
                "}\n";

            stmt.executeUpdate(javaSrc);
            System.out.println("Java source loaded successfully!");

            // Commit the transaction
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}