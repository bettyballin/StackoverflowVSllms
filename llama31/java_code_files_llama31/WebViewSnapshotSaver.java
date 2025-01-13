/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.os.Bundle
 *  android.os.Environment
 *  android.util.Log
 *  android.webkit.WebView
 */
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.webkit.WebView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebViewSnapshotSaver
extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebView webView = new WebView((Context)this);
        webView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap((Bitmap)webView.getDrawingCache());
        webView.setDrawingCacheEnabled(false);
        String string = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String string2 = "snapshot_" + string + ".jpg";
        File file = Environment.getExternalStoragePublicDirectory((String)Environment.DIRECTORY_PICTURES);
        File file2 = new File(file, string2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)fileOutputStream);
            fileOutputStream.close();
        }
        catch (FileNotFoundException fileNotFoundException) {
            Log.e((String)"snapshot", (String)("File not found: " + fileNotFoundException.getMessage()));
        }
        catch (IOException iOException) {
            Log.e((String)"snapshot", (String)("Error accessing file: " + iOException.getMessage()));
        }
    }

    public static void main(String[] stringArray) {
    }
}
