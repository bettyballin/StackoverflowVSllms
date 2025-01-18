import java.util.regex.*;
public class TEST {
    public static void main(String[] args){
        String str = "<UL>\n"
            + "<LI class=\"test\">This is the first ListItem Text. \n"
            + "<LI>This is the second ListItem Test.</LI></UL>";
        String patternString = "<li[^>]*>(.*?)</li>\\\\s*?(?:(?!</?li>)[\\\\s\\\\S])*(?!<li)";
        Pattern p = Pattern.compile(patternString);
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println("Found value: " + m.group(0));
        }
    }
}