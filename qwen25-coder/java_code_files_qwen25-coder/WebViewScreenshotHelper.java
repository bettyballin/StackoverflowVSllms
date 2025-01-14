import android.webkit.WebView;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.content.Context;
import android.provider.MediaStore;
import android.net.Uri;
import android.content.Intent;
import android.os.Environment;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

public class WebViewScreenshotHelper {
    // Method to take a screenshot of the WebView
    public void captureWebview(WebView webView) {
        webView.setDrawingCacheEnabled(true);
        webView.buildDrawingCache();
        Bitmap b = Bitmap.createBitmap(webView.getMeasuredWidth(), webView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        
        Canvas c = new Canvas(b);
        webView.draw(c);
    
        // Save the captured image to gallery
        saveImageToGallery(this, b);
    }
    
    // Method to save a bitmap into the device's photo gallery
    private void saveImageToGallery(Context context, Bitmap bmp) {
        FileOutputStream outStream = null;
        String url = MediaStore.Images.Media.insertImage(context.getContentResolver(), bmp, "WebViewSnap", "description");
        try {
            Uri uri = Uri.parse(url);
            outStream = new FileOutputStream(new File(uri.getPath()));
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
            outStream.flush();
            outStream.close();
    
            // Notify the system gallery of the image
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED,
                    Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    	public static void main(String[] args) {
    	}
}