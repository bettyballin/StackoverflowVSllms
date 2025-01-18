public class SmsManagerorUnreadSmsCounterwouldbeappropriateclassnames {

    int unreadSmsCount = 0;
    Uri uri;
    String selection;
    Cursor cursor;

    {
        uri = Uri.parse("content://sms");
        selection = "read = 0"; // 0 is for unread messages
        cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            unreadSmsCount = cursor.getCount();
            cursor.close();
        }
    }

    public static void main(String[] args) {
    }

    // Dummy definitions to make the code compile
    static class Uri {
        public static Uri parse(String s) {
            return new Uri();
        }
    }

    static class Cursor {
        public int getCount() {
            return 0;
        }
        public void close() {
        }
    }

    public ContentResolver getContentResolver() {
        return new ContentResolver();
    }

    class ContentResolver {
        public Cursor query(Uri uri, String[] projection, String selection,
                            String[] selectionArgs, String sortOrder) {
            return new Cursor();
        }
    }
}