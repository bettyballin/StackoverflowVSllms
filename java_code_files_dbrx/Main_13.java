public class Main {

    public static void main(String[] args){

        // "Happy & Sad" in HTML form.
        String s = "Happy &amp; Sad";
        System.out.println(s);

        try{
            // Change to "Happy & Sad". WORKS!
            s = unescapeHtml4(s);
            System.out.println(s);
        } catch (Exception ex){
            // Handle exceptions if necessary
        }
    }

    public static String unescapeHtml4(String s) {
        // Simple implementation to unescape HTML entities
        s = s.replace("&lt;", "<");
        s = s.replace("&gt;", ">");
        s = s.replace("&amp;", "&");
        s = s.replace("&quot;", "\"");
        s = s.replace("&apos;", "'");
        s = s.replace("&#39;", "'");
        // Add more replacements if needed
        return s;
    }
}