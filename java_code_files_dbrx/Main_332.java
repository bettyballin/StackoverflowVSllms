public class Main_332 {
    public static void main(String[] args) {
        String input = "<Hello>";
        String escaped = StringEscapeUtils.escapeHtml4(input);
        System.out.println(escaped);  // prints: &lt;Hello&gt;
    }
}

class StringEscapeUtils {
    public static String escapeHtml4(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            switch(c) {
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '"':
                    sb.append("&quot;");
                    break;
                case '\'':
                    sb.append("&#x27;");
                    break;
                case '/':
                    sb.append("&#x2F;");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        return sb.toString();
    }
}