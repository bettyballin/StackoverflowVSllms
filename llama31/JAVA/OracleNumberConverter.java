import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.sql.NUMBER;

public class OracleNumberConverter {
    public static void main(String[] args) {
        // You need to create a ResultSet object (rs) and initialize colIndex variable
        // For demonstration purposes, assume rs and colIndex are already initialized
        ResultSet rs = null;
        int colIndex = 0;
        
        try {
            oracle.sql.NUMBER number = (oracle.sql.NUMBER) rs.getObject(colIndex);
            BigDecimal bigDecimal = number.toBigDecimal();
        } catch (SQLException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }
}