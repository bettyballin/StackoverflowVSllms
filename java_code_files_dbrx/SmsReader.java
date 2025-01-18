public class SmsReader {
    public void readMessages() {
        String smsc = "";
        Uri uri = Uri.parse("content://sms/" + smsc);
        ContentResolver contentResolver = new ContentResolver();
        Cursor cursor = contentResolver.query(uri, null,"read=0",null,null); //change read query according to requirement like 1 for already read messages and so on..
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String addNumber = cursor.getString(2);
                Log.d("addNumber", addNumber);
            }
        }
    }

    public static void main(String[] args) {
        new SmsReader().readMessages();
    }
}

class Uri {
    public static Uri parse(String uriString) {
        return new Uri();
    }
}

class ContentResolver {
    public Cursor query(Uri uri, Object projection, String selection, Object selectionArgs, Object sortOrder) {
        return new Cursor();
    }
}

class Cursor {
    public boolean moveToNext() {
        return false;
    }
    public String getString(int index) {
        return "";
    }
}

class Log {
    public static void d(String tag, String msg) {
        System.out.println(tag + ": " + msg);
    }
}