/*
 * Decompiled with CFR 0.152.
 */
import java.sql.SQLException;

public class SQLExceptionHandler {
    public static void main(String[] stringArray) {
        SQLException sQLException = new SQLException();
        String string = sQLException.getSQLState();
        int n = sQLException.getErrorCode();
    }
}
