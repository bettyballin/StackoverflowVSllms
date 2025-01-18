import java.lang.String;
public class Main_333 {
    public static void main(String[] args) {
        String input = "<Hello>";
        String escaped = escapeHtmlChars(input);
        System.out.println(escaped);  // prints: &lt;Hello&gt;
    }

    private static String escapeHtmlChars(String htmlString) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<htmlString.length()-1;i++) {
            char c = htmlString.charAt(i);
            if (c=='<') {
                sb.append("&lt;");
            } else if (c=='>') {
                sb.append("&gt;");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}