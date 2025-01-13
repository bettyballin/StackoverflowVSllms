import java.util.HashMap;
import java.util.Map;

public class Main_552 {
    public static void main(String[] args) {
        // Simulate the request.getParameter() method
        Map<String, String> params = new HashMap<>();
        params.put("textareaName", "Hello\r\nWorld\nThis is a test.");

        String text = params.get("textareaName");
        text = text.replace("\r\n", "<br/>").replace("\n", "<br/>");
        System.out.println(text);
    }
}