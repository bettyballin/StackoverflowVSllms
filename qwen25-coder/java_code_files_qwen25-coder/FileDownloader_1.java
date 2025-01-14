import java.io.*;
import java.net.*;
import java.util.*;

public class FileDownloader_1 {
    private static final String baseURL = "https://your.base.url/";
    private static Map<String, URL> urlMap;
    private static CookieManager cookieManager;

    public static void main(String[] args) throws IOException {
        setup();
        login();
        downloadFile();
        logout();
    }

    private static void setup() throws MalformedURLException {
        urlMap = new HashMap<>();
        urlMap.put("login", new URL(baseURL + "exec.asp?login=username&pass=XPTO"));
        urlMap.put("logout", new URL(baseURL + "exec.asp?page=999"));
        urlMap.put("file", new URL(baseURL + "exec.asp?file=111"));

        // Use CookieManager to handle the cookie session
        cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
    }

    private static void login() throws IOException {
        URLConnection urlConnection = urlMap.get("login").openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine); // Just for debugging, remove if not needed
        }
        in.close();
    }

    private static void downloadFile() throws IOException {
        URLConnection urlConnection = urlMap.get("file").openConnection();
        try (BufferedInputStream bis = new BufferedInputStream(urlConnection.getInputStream());
             FileOutputStream fos = new FileOutputStream("downloaded_file.ext")) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer, 0, 1024)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    private static void logout() throws IOException {
        URLConnection urlConnection = urlMap.get("logout").openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        // Optionally read the response to confirm logout
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine); // Just for debugging, remove if not needed
        }
        in.close();
    }
}