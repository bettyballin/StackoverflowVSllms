public class UrlSafeStringGenerator {
    String safeURL = new JavaScriptEncoder().encode("https://www.example.com"); 
    // returns https:\/\/www.example.com which can be safely embedded
    public static void main(String[] args) {
    }
}

class JavaScriptEncoder {
    public String encode(String s) {
        return s.replace("/", "\\/");
    }
}