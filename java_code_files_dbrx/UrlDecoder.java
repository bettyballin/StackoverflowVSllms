public class UrlDecoder {
    String encoded;
    String decoded;
    {
        try {
            decoded = java.net.URLDecoder.decode(encoded, "UTF-8"); // For URL Decoding in Java, similar functions exist on PHP
        } catch (java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
    }
}