import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

public class ScoreRetriever {
    public static void main(String[] args) {
        // Create an instance of the class to call the non-static method
        ScoreRetriever retriever = new ScoreRetriever();
        retriever.retrieveScore();
    }

    public void retrieveScore() {
        // Assuming Scores.CONTENT_URI points to your scores table
        Uri uri = Scores.CONTENT_URI;
        String[] projection = new String[]{"MAX(points)"};

        // Get a ContentResolver instance
        ContentResolver contentResolver = getContentResolver();

        // Query the content resolver
        Cursor cursor = contentResolver.query(uri, projection, null, null, null);
        // You should close the cursor when you're done with it to avoid memory leaks
        if (cursor != null) {
            cursor.close();
        }
    }

    // You need to define getContentResolver() method in your class or get it from context
    private ContentResolver getContentResolver() {
        // For the sake of this example, let's assume we have a context
        // In a real-world application, you would get this from an Activity or Application
        // Context context = ...;
        // return context.getContentResolver();
        return null; // Return null for now to avoid compilation errors
    }
}

// You need to define the Scores class with the CONTENT_URI
class Scores {
    public static final Uri CONTENT_URI = Uri.parse("content://your.authority/your/path");
}