import java.lang.String;

public class SmsReader {

    public static void main(String[] args) {

        final Uri uri = Uri.parse("content://sms/inbox");
        final String[] projection = {"_id", "thread_id", "address", "person", "date", "body", "type"};
        final String where = "read=0";
        Cursor cursor = getContentResolver().query(uri, projection, where, null, "date DESC");
   
        if (cursor != null) {
           int count = cursor.getCount();
           System.out.println("Unread SMS Count: " + count);
           cursor.close();
       }
    }

    public static ContentResolver getContentResolver() {
         return new ContentResolver();
    }
}

class Uri {
   private String uriString;
   
   private Uri(String uriString) {
       this.uriString = uriString;
   }
   
   public static Uri parse(String uriString) {
       return new Uri(uriString);
   }
}

class Cursor {
    public int getCount() {
        return 0; // dummy value
    }

    public void close() {
    }
}

class ContentResolver {
    public Cursor query(Uri uri, String[] projection, String where, Object o, String orderBy) {
        // For now, return a dummy cursor
        return new Cursor();
    }
}