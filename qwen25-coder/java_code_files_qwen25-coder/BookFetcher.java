import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BookFetcher {
    public static String fetchBookTitle(String isbn) throws Exception {
        String url = "https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Convert JSON string into JSONObject, etc., to extract title
        // Here's a simple example using substring search. For production, use JSON library.
        String jsonResponse = response.toString();
        if (jsonResponse.contains("title")) {
            int start = jsonResponse.indexOf("\"title\": \"") + 10;
            int end = jsonResponse.indexOf("\"", start);
            return jsonResponse.substring(start, end);
        } else {
            return "Book not found.";
        }
    }

    public static void main(String[] args) throws Exception {
        String isbn = "9783161484100";
        String title = fetchBookTitle(isbn);
        System.out.println("The title of the book is: " + title);
    }
}