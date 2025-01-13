/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class HttpDownload {
    public static void main(String[] stringArray) throws Exception {
        URL uRL = new URL("https://example.com");
        HashMap<String, URL> hashMap = new HashMap<String, URL>();
        hashMap.put("login", new URL(uRL, "exec.asp?login=username&pass=XPTO"));
        hashMap.put("logout", new URL(uRL, "exec.asp?exec.asp?page=999"));
        hashMap.put("file", new URL(uRL, "exec.asp?file=111"));
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
        URLConnection uRLConnection = ((URL)hashMap.get("login")).openConnection();
        uRLConnection.getContent();
        URLConnection uRLConnection2 = ((URL)hashMap.get("file")).openConnection();
        try (InputStream inputStream = uRLConnection2.getInputStream();
             FileOutputStream fileOutputStream = new FileOutputStream("downloadedFile");){
            int n;
            byte[] byArray = new byte[1024];
            while ((n = inputStream.read(byArray)) != -1) {
                fileOutputStream.write(byArray, 0, n);
            }
        }
    }
}
