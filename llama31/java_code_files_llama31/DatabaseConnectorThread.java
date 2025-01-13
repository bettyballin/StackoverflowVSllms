/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectorThread {
    Thread thread = new Thread(new Runnable(this){

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
    });

    public static void main(String[] stringArray) {
        DatabaseConnectorThread databaseConnectorThread = new DatabaseConnectorThread();
        databaseConnectorThread.thread.start();
        databaseConnectorThread.thread.interrupt();
    }
}
