public class Main {
    public static void main(String[] args) {
        String cleanedContent = "<i>stack\n<span class=\"bold\">overflow</span></i>\n";
        cleanedContent = cleanedContent.replaceAll("\\s+", " "); // Replace multiple consecutive whitespaces with a single space
        System.out.println(cleanedContent); // Output will have a fixed spacing issue
    }
}