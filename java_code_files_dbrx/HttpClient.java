import java.io.*;
import java.net.*;
import java.util.*;
import java.util.function.Predicate;

public class HttpClient {
    private Map<String, List<String>> cookies;
    private CookieManager manager = new CookieManager();
    protected String charset;

    public HttpClient() {
        this.charset = "UTF-8";
        this.cookies = new HashMap<>();
        this.manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
    }

    public void loginAndDownloadFile(String baseUrl, Map<String, URL> urlMap) {
        for (String key : Arrays.asList("login", "logout", "file")) { // Change this order according to your needs: login, logout/action, download URLs)
            try {
                URL currentURL = urlMap.get(key);

                HttpURLConnection request = postRequest(currentURL, baseUrl);

                if ("login".equals(key)) {
                    // Extract and store cookies for future requests:
                    Map<String, List<String>> responseHeaders = request.getHeaderFields();
                    setCookies(responseHeaders);
                } else if ("logout".equals(key)) { // Use this case to perform other actions after a session login and before downloading the file
                    executeAndPrintResult("After logout: ", request.getInputStream());
                } else if ("file".equals(key)) {
                    try (InputStream inputStream = new BufferedInputStream(request.getInputStream());
                         FileOutputStream outputStream = new FileOutputStream("/path/to/save/" + new Date().getTime() /* or file ID */ + ".pdf")) { // Update extension accordingly
                        int bytesRead;
                        byte[] buffer = new byte[1024];
                        while ((bytesRead = inputStream.read(buffer, 0, 1024)) != -1) {
                            outputStream.write(buffer, 0, bytesRead);
                        }
                    } catch (IOException e) {
                        System.out.println("Error downloading file: " + e.getMessage());
                    }
                } else {
                    // Other actions to be performed based on keys from urlMap
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                cookies = new HashMap<>(); // Clear cookies after downloading or for the next test
            }
        }
    }

    private HttpURLConnection postRequest(URL currentUrl, String baseUrl) throws Exception {
        CookieHandler.setDefault(manager);
        URL urlObj = createCurrentURLWithCookiesAndCharset(currentUrl, baseUrl); // Update charset if required in your response
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

        con.setRequestMethod("POST");
        con.setDoInput(true);
        con.setDoOutput(true);

        return con;
    }

    private URL createCurrentURLWithCookiesAndCharset(URL currentURL, String baseUrl) throws MalformedURLException {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("https://"); // Add 's' if your site is secured
        String hostName = currentURL.getHost();
        stringBuffer.append(hostName);
        stringBuffer.append('/');
        int offset = baseUrl.indexOf("/", 8) + 1;
        int len = baseUrl.length() - offset;
        if (len > 0) {
            stringBuffer.append(baseUrl, offset, offset + len);
        }
        stringBuffer.append("?")
            .append(String.format("%s=%s&%s=%s", "loginNameFromSiteQueryParam", "username", "passwordFromSiteQueryParam", "YOUR-PASSWORD"));
        URL urlObj = new URL(stringBuffer.toString());

        return urlObj;
    }

    private String executeAndPrintResult(String prefix, InputStream is) throws IOException {
        if (is != null && charset != null) {
            try (Reader reader = new BufferedReader(new InputStreamReader(is, charset))) {
                int c;
                while ((c = reader.read()) != -1) {
                    System.out.print((char) c);
                }
            } catch (IOException e) {
                throw new IOException("Error reading " + prefix, e);
            }
        } else if (is == null) {
            System.err.println(prefix + ": No content returned");
        } else {
            System.err.print("Charset is null: "); // Should be handled differently
        }
        return "";
    }

    private void setCookies(Map<String, List<String>> responseHeaders) {
        manager.getCookieStore().removeAll(); // Remove all cookies before storing new ones for login request
        if (responseHeaders != null && !responseHeaders.isEmpty()) {
            String cookieHeader = "Set-Cookie";
            cookies = getCookieMap(cookies);
            processCookies(responseHeaders, headerName -> containsExpectedName(cookieHeader, headerName)); // Cookies may be returned based on `set-cookie` or `Set-Cookie`. Check your target website headers section.
        } else {
            System.out.println("Response Headers is null");
        }
    }

    private boolean containsExpectedName(String expectedHeader, String providedHeader) {
        return expectedHeader.equalsIgnoreCase(providedHeader);
    }

    private Map<String, List<String>> getCookieMap(Map<String, List<String>> cookies) {
        if (cookies == null || cookies.isEmpty()) {
            this.cookies = new HashMap<>(); // Initialize default map when needed
        } else {
            this.cookies = cookies;
        }
        return this.cookies;
    }

    private void processCookies(Map<String, List<String>> responseHeaders, Predicate<String> headerNameFilter) {
        for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
            String headerName = entry.getKey();
            if (headerNameFilter.test(headerName)) {
                List<String> headerValues = entry.getValue();
                for (String headerValue : headerValues) {
                    // Process the cookie
                    List<HttpCookie> cookiesList = HttpCookie.parse(headerValue);
                    for (HttpCookie cookie : cookiesList) {
                        manager.getCookieStore().add(null, cookie);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}