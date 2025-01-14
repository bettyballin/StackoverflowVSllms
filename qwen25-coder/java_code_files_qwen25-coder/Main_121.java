public class Main {
    public static void main(String[] args) {
        String html = "<div>Hello <p>World</p></div><span>Test</span><p>Remove this</p>";
        String result = removeTag(html, "p");
        System.out.println(result);
        // Output: <div>Hello </div><span>Test</span>
    }

    public static String removeTag(String html, String tagName) {
        String regex = "<" + tagName + "\\\\b[^>]*>.*?</" + tagName + ">";
        return html.replaceAll(regex, "");
    }
}