public class Main_535 {
    public static void main(String[] args) {
        String htmlString = "<html><body><a href='https://example.com'>Example</a></body></html>";
        int startIndex = htmlString.indexOf("<a href=");
        int endIndex = htmlString.indexOf("</a>");
        
        if (startIndex != -1 && endIndex != -1) {
            String aTag = htmlString.substring(startIndex, endIndex + 4);
            System.out.println("Extracted <a> tag: " + aTag);
        } else {
            System.out.println("No <a> tags found.");
        }
    }
}