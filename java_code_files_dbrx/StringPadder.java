import java.lang.String;
public class StringPadder {
public static void main(String[] args) {
    int len = 10;
    char padChar = '0';
    String str = "Hello";
    // if string too long, pad to length + str.length())
    while (str.length() < len ) str += Character.toString(padChar);
    System.out.println("Padded: " +  str);
}
}