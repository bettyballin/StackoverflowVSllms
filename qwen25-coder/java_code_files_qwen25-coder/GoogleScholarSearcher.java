import java.io.UnsupportedEncodingException;
public class GoogleScholarSearcher {
    public void searchGoogleScholar(String query) throws UnsupportedEncodingException {
        String baseUrl = "https://scholar.google.com/scholar";
        String queryString = "?q=" + java.net.URLEncoder.encode(query, "UTF-8");
        System.out.println("Search URL: " + baseUrl + queryString);
    }
    public static void main(String[] args) {
    }
}