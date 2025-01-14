public class DatabaseHelper_1 {
    private static final String KEY_NAME = "key_name";
    private static final String VALUE = "value";
    private static final String DATABASE_TABLE = "database_table";

    private long insertRow(int rowParameter, String rowValue, SQLiteDatabase db) {
        long res = -1;
        ContentValues settingsParameterValues = new ContentValues();
        settingsParameterValues.put(KEY_NAME, rowParameter);
        settingsParameterValues.put(VALUE, rowValue);
        if (db != null) {
            try {
                res = db.insert(DATABASE_TABLE, null, settingsParameterValues);
            } catch (SQLiteConstraintException e) {
                // Handle the duplicate entry scenario
                Log.e("Database", "Attempt to insert a duplicate key: " + rowParameter, e);
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}

class ContentValues {
    public ContentValues() {}
    public void put(String key, int value) {}
    public void put(String key, String value) {}
}

class SQLiteDatabase {
    public long insert(String table, String nullColumnHack, ContentValues values) throws SQLiteConstraintException {
        return 1; // Stub implementation
    }
}

class SQLiteConstraintException extends Exception {
    public SQLiteConstraintException(String message) {
        super(message);
    }

    public SQLiteConstraintException(String message, Throwable cause) {
        super(message, cause);
    }
}

class Log {
    public static void e(String tag, String message, Throwable tr) {
        System.err.println(tag + ": " + message);
        tr.printStackTrace();
    }
}