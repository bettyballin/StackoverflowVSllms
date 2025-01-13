/*
 * Decompiled with CFR 0.152.
 */
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseCodePrinter {
    public static void main(String[] stringArray) {
        ResultSet resultSet = null;
        try {
            String string = resultSet.getString("code");
            System.out.println(string);
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
