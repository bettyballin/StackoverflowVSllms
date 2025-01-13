import java.lang.String;
public class StringConcatenator {
public static void main(String[] args) {
    String string1 = "This is a string1";
    String string2 = "This is a string2";
    String string3 = string1.concat(string2);
    System.out.println(string3);
}
}