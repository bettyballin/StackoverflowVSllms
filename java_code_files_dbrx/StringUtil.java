import java.util.ArrayList;
import java.util.List;

public class StringUtil {
    List<String> sList = new ArrayList<>();
    // Add elements

    String concatenatedString;

    {
        StringBuilder sb = new StringBuilder();
        for(String str : sList) {
            sb.append(str);
        }
        concatenatedString = sb.toString();
    }

    public static void main(String[] args) {
    }
}