public class HtmlDecoder {
    public static String unescapeHtml4(String input) {
        return input.replace("&nbsp;", " ")
                    .replace("&gt;", ">")
                    // Add more replacements as needed
                    ;
    }

    public static void main(String[] args) {
        String encodedHtml = "This is an example &nbsp; with &gt; special characters.";
        String decodedHtml = unescapeHtml4(encodedHtml);
        System.out.println(decodedHtml);
    }
}