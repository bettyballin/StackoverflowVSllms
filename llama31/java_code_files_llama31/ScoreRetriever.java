/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.Cursor
 *  android.net.Uri
 */
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

public class ScoreRetriever {
    public static void main(String[] stringArray) {
        ScoreRetriever scoreRetriever = new ScoreRetriever();
        scoreRetriever.retrieveScore();
    }

    public void retrieveScore() {
        Uri uri = Scores.CONTENT_URI;
        String[] stringArray = new String[]{"MAX(points)"};
        ContentResolver contentResolver = this.getContentResolver();
        Cursor cursor = contentResolver.query(uri, stringArray, null, null, null);
        if (cursor != null) {
            cursor.close();
        }
    }

    private ContentResolver getContentResolver() {
        return null;
    }
}
