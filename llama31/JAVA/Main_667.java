public class Main_667 {
    public static void main(String[] args) {
        String url = "http://example.com/path with spaces";
        String encodedUrl = url.replace(" ", "%20");
        System.out.println(encodedUrl); // prints http://example.com/path%20with%20spaces
    }
}