// Import necessary classes
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class SMSReader {

    public void readSMS(Context context) {
        // Define the URI for each type of SMS
        Uri inboxUri = Uri.parse("content://sms/inbox");
        Uri sentUri = Uri.parse("content://sms/sent");
        Uri draftUri = Uri.parse("content://sms/draft");

        // Read messages from all URIs
        readMessagesFromUri(context, inboxUri);
        readMessagesFromUri(context, sentUri);
        readMessagesFromUri(context, draftUri);
    }

    // Function to print messages from a given URI
    void readMessagesFromUri(Context context, Uri uri) {
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String address = cursor.getString(cursor.getColumnIndex("address"));
                String body = cursor.getString(cursor.getColumnIndexOrThrow("body"));
                System.out.println("From: " + address + ", Message: " + body);
            } while (cursor.moveToNext());
            cursor.close();
        }
    }
}