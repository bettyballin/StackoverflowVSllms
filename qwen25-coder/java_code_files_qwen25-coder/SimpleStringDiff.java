import java.lang.String;
public class SimpleStringDiff {

    public static void main(String[] args) {
        System.out.println(diffWithIndices("abcd", "aacd"));
        System.out.println(diffWithHtml("abcd", "aacd"));

        System.out.println(diffWithIndices("maniac", "brainiac"));
        System.out.println(diffWithHtml("maniac", "brainiac"));
    }

    public static String diffWithHtml(String a, String b) {
        StringBuilder html = new StringBuilder();
        int maxLength = Math.max(a.length(), b.length());

        for (int i = 0; i < maxLength; i++) {
            char charA = i < a.length() ? a.charAt(i) : ' ';
            char charB = i < b.length() ? b.charAt(i) : ' ';

            if (charA == charB) {
                html.append(charA);
            } else {
                html.append("<span style='background-color:yellow;'>").append(charA).append("</span>");
            }
        }

        return html.toString();
    }

    public static String diffWithIndices(String a, String b) {
        StringBuilder indices = new StringBuilder("[");
        int length = Math.min(a.length(), b.length());

        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (indices.length() > 1) {
                    indices.append(",");
                }
                indices.append(i);
            }
        }

        // Append remaining characters if lengths differ
        if (a.length() != b.length()) {
            for (int i = length; i < Math.max(a.length(), b.length()); i++) {
                if (indices.length() > 1) {
                    indices.append(",");
                }
                indices.append(i);
            }
        }

        return indices.append("]").toString();
    }
}