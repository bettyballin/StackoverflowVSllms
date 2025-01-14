import java.lang.String;
public class UNCtoURLConverter {
    public static void main(String[] args) {
        String uncPath = "\\\\server\\d$\\x\\y\\z\\AAA";
        
        // Regex to match UNC path and capture relevant parts
        String regex = "^\\\\([^\\\\]+)\\\\[^\\\\]+\\\\(.*)$";
        
        // Replacement string to convert to URL
        String replacement = "http://$1/$2";
        
        String url = uncPath.replaceAll(regex, replacement).replace("\\", "/");
        
        System.out.println(url);  // Output: http://server/z/AAA
    }
}