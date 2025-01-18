import java.lang.String;

public class SMSReader {
    public SMSReader() {
        Uri uri = Uri.parse("content://sms/inbox");
        String[] projection = new String[] { "_id", "address", " person", "body", "date", "type" };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        while (cursor.moveToNext()) {
            Long timestamp = cursor.getLong(4);
            String msg = cursor.getString(3).toString();
        }
    }

    public ContentResolver getContentResolver() {
        return new ContentResolver();
    }

    public static void main(String[] args) {
    }
}

class Uri {
    public static Uri parse(String uriString) {
        return new Uri();
    }
}

class Cursor {
    public boolean moveToNext() {
        return false;
    }

    public Long getLong(int index) {
        return 0L;
    }

    public String getString(int index) {
        return "";
    }
}

class ContentResolver {
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return new Cursor();
    }
}