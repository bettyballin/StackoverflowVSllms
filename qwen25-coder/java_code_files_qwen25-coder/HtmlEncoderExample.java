import org.owasp.esapi.ESAPI;

public class HtmlEncoderExample {
    // Example of HTML encoding in Java using OWASP Encoder library
    String userInput;
    String safeOutput = ESAPI.encoder().encodeForHTML(userInput);

    public static void main(String[] args) {
    }
}