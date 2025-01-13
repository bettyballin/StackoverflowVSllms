import java.util.UUID;

public class Main_655 {
    public static void main(String[] args) {
        String boundary = "---------------------------" + UUID.randomUUID().toString();

        // ...

        String contentType = "multipart/mixed; boundary=\"" + boundary + "\"";

        // ...

        String body = "--" + boundary + "\r\n" +
                "Content-Type: text/plain; charset=\"iso-8859-1\"\r\n" +
                "Content-Transfer-Encoding: base64\r\n" +
                "\r\n" +
                "BASE64ENCODING\r\n" +
                "--" + boundary + "--\r\n";

        System.out.println(contentType);
        System.out.println(body);
    }
}