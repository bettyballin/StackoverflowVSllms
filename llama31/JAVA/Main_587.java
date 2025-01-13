import java.util.*;

public class Main_587 {
    public static void main(String[] args) {
        List<String> collectionOfStrings = Arrays.asList("apple", "banana", "cherry");
        StringBuilder sb = new StringBuilder();
        for (String s : collectionOfStrings) {
            sb.append(s).append(",");
        }
        String result = sb.toString().replaceAll(",$", ""); // remove trailing comma
        System.out.println(result);
    }
}