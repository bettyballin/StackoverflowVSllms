/*
 * Decompiled with CFR 0.152.
 */
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public static void main(String[] stringArray) {
    }

    public static interface Connection {
        public Statement createStatement() throws SQLException;

        public void commit() throws SQLException;

        public void close() throws SQLException;
    }
}
