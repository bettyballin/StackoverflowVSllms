import java.lang.String;
public class SplitString_1 {
    public static void main(String[] args) {
        String input = "9,admin@example.com,8";
        String[] resultArray = input.split(",");

        for (String element : resultArray) {
            System.out.println(element);
        }
    }
}