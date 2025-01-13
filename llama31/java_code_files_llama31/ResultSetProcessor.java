/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  MockResultSet
 */
import java.sql.SQLException;

public class ResultSetProcessor {
    public static void main(String[] stringArray) {
        MockResultSet mockResultSet = new MockResultSet();
        Double d = null;
        try {
            d = (Double)mockResultSet.getObject(1);
        }
        catch (SQLException sQLException) {
            System.out.println("Error getting object from ResultSet: " + sQLException.getMessage());
        }
        if (d == null) {
            System.out.println("d is null");
        } else {
            System.out.println("d value: " + d);
        }
    }
}
