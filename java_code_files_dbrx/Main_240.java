import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class Main_240 {
    public static void main(String[] args) throws Exception {
        Connection.Response res = Jsoup.connect("https://your-cellphone-provider.com/form")
                .method(Connection.Method.GET)
                .execute(); // load form page

        Document doc = res.parse(); // parse HTML response into document object for easier manipulation and querying

        Element form = doc.getElementById("form-id"); // get the form element by its ID (replace with your actual form id attribute value)

        // Set desired values to each input field elements based on their id attributes (replace accordingly)
        Element inputField1 = form.getElementById("input-field1-id");
        inputField1.val("value1");

        Element inputField2 = form.getElementById("input-field2-id");
        inputField2.val("value2");

        // Prepare form data
        Map<String, String> formData = new HashMap<>();
        Elements inputElements = form.getElementsByTag("input");
        for (Element inputElement : inputElements) {
            String key = inputElement.attr("name");
            String value = inputElement.val();
            formData.put(key, value);
        }

        Connection postFormBodyConn = Jsoup.connect("https://your-cellphone-provider.com/form")
                .cookies(res.cookies())  // use cookies from first request to maintain session context (if required)
                .referrer("https://your-cellphone-provider.com/form") // optional: provide a valid referer header field value for the subsequent POST request
                .data(formData) // include form data
                .method(Connection.Method.POST);

        Connection.Response postFormResp = postFormBodyConn.execute(); // send the filled out form as a POST request

        System.out.println("Submitted form successfully");
    }
}