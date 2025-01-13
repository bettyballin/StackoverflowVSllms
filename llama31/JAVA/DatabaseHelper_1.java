import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;

public class DatabaseHelper_1_1 {
    private static final String KEY_NAME = "name";
    private static final String VALUE = "value";
    private static final String DATABASE_TABLE = "table_name";

    private long insertRow(int rowParameter, String rowValue, SQLiteDatabase db){
        long res = -1;
        ContentValues settingsParameterValues = new ContentValues();
        settingsParameterValues.put(KEY_NAME, rowParameter);
        settingsParameterValues.put(VALUE, rowValue);
        if(db != null){
            res = db.replace(DATABASE_TABLE, null, settingsParameterValues);
        }
        return res;
    }

    public static void main(String[] args) {
    }
}