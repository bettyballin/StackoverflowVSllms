/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseConnectorThread.1
implements Runnable {
    DatabaseConnectorThread.1(DatabaseConnectorThread databaseConnectorThread) {
    }

    @Override
    public void run() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("your_url", "your_user", "your_password");
        }
        catch (SQLException sQLException) {
        }
        finally {
            if (Thread.currentThread().isInterrupted()) {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                }
                catch (SQLException sQLException) {}
            }
        }
    }
}
