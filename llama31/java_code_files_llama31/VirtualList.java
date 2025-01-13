/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class VirtualList {
    private Connection connection;
    private String query;
    private int pageSize;

    public VirtualList(Connection connection, String string, int n) {
        this.connection = connection;
        this.query = string;
        this.pageSize = n;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Customer get(int n) {
        try (Statement statement = this.connection.createStatement();){
            int n2 = n / this.pageSize * this.pageSize;
            String string = this.query + " LIMIT " + this.pageSize + " OFFSET " + n2;
            try (ResultSet resultSet = statement.executeQuery(string);){
                int n3 = n2;
                while (resultSet.next()) {
                    if (n3 == n) {
                        Customer customer = new Customer(resultSet.getInt("ID"), resultSet.getString("NAME"), resultSet.getString("COUNTRY"));
                        return customer;
                    }
                    ++n3;
                }
                return null;
            }
        }
        catch (SQLException sQLException) {
            System.out.println("Error retrieving customer: " + sQLException.getMessage());
        }
        return null;
    }
}
