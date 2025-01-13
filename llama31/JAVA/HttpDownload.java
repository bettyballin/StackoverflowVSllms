import java.io.*;
import java.net.*;
import java.util.*;

public class HttpDownload {
    public static void main(String[] args) throws Exception {
        URL baseURL = new URL("https://example.com");
        Map<String, URL> urlMap = new HashMap<>();
        urlMap.put("login", new URL(baseURL, "exec.asp?login=username&pass=XPTO"));
        urlMap.put("logout", new URL(baseURL, "exec.asp?exec.asp?page=999"));
        urlMap.put("file", new URL(baseURL, "exec.asp?file=111"));

        // Create a cookie manager
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        // Login
        URLConnection loginConnection = urlMap.get("login").openConnection();
        loginConnection.getContent(); // execute the login request

        // Download file
        URLConnection fileConnection = urlMap.get("file").openConnection();
        try (InputStream in = fileConnection.getInputStream();
             FileOutputStream out = new FileOutputStream("downloadedFile")) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}