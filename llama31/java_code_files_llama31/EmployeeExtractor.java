/*
 * Decompiled with CFR 0.152.
 */
import java.lang.invoke.CallSite;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class EmployeeExtractor {
    public static void main(String[] stringArray) {
        ResultSet resultSet = null;
        try {
            HashSet<CallSite> hashSet = new HashSet<CallSite>();
            while (resultSet.next()) {
                String string = resultSet.getString("employee_id");
                String string2 = resultSet.getString("name");
                hashSet.add((CallSite)((Object)(string + ":" + string2)));
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
