import java.lang.String;
import java.lang.Integer;
public class SettingsDbHelper {
    private static final String DATABASE_TABLE = "someTable";
    private static final String VALUE = "value";
    private static final String KEY_NAME = "keyName";

    private long insertOrUpdateRow(int rowParameter, String rowValue, SQLiteDatabase db) {
        long res = -1;
        ContentValues settingsParameterValues = new ContentValues();
        settingsParameterValues.put(VALUE, rowValue);

        // Try to update the existing record where it's possible
        int rowsAffected = db.update(DATABASE_TABLE, settingsParameterValues, KEY_NAME + "=?", new String[]{Integer.toString(rowParameter)});  // '?' is for parameter to prevent SQL injection

        if(rowsAffected == 0) {   // if no rows affected -> insert a new one
            settingsParameterValues.put(KEY_NAME, rowParameter);   // add KEY_NAME into ContentValues so that the new record will be created correctly
            res = db.insertWithOnConflict(DATABASE_TABLE, null, settingsParameterValues, SQLiteDatabase.CONFLICT_IGNORE);
        } else {
            res = 0;   // return zero instead of -1 to signal that no new record was inserted but the existing one was updated
        }

        return res;
    }
    public static void main(String[] args) {
    }
}

// Define ContentValues class
class ContentValues {
    public void put(String key, String value) {
        // dummy implementation
    }
    public void put(String key, int value) {
        // dummy implementation
    }
}

// Define SQLiteDatabase class
class SQLiteDatabase {
    public static final int CONFLICT_IGNORE = 0;

    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        // dummy implementation
        return 0;
    }

    public long insertWithOnConflict(String table, String nullColumnHack, ContentValues initialValues, int conflictAlgorithm) {
        // dummy implementation
        return 0;
    }
}