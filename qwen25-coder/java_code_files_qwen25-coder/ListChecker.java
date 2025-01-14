import java.util.List;
import java.util.ArrayList;

public class ListChecker {
    public static boolean isGenericList(Object obj) {
        return obj instanceof List;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(isGenericList(list)); // Should print: true

        String notAList = "Hello, World!";
        System.out.println(isGenericList(notAList)); // Should print: false
    }
}