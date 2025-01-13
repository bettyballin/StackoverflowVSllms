/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerCounter {
    public static int countCustomers(Connection connection, String string, int n) throws SQLException {
        String string2 = "SELECT COUNT(*) as numCustomers FROM CUSTOMER C JOIN RENTS R ON C.ID = R.cid WHERE C.ST = ? AND R.mid = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(string2);){
            preparedStatement.setString(1, string);
            preparedStatement.setInt(2, n);
            try (ResultSet resultSet = preparedStatement.executeQuery();){
                if (resultSet.next()) {
                    int n2 = resultSet.getInt("numCustomers");
                    return n2;
                }
            }
        }
        return 0;
    }

    public static void main(String[] stringArray) {
    }
}
