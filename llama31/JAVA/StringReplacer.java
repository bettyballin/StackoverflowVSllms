import java.lang.String;

public class StringReplacer {
    public static void main(String[] args) {
        String originalString = "VALUES (12654, 'somestuff', 'some description here', 'filename.swf', '5', 0, 1, '', '500', '300', 'filename.png', '3', '1');";
        String replacedString = originalString.replaceAll("'([^']*)\\.(swf|png)'", "'folder/$1.$2'");
        System.out.println(replacedString);
    }
}