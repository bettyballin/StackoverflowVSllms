import java.util.ArrayList;
import java.util.List;

public class StringListConcatenator {
    List<String> sList = new ArrayList<>();
    // Add elements

    String concatenatedString;

    public StringListConcatenator() {
        concatenatedString = String.join("", sList);
    }

    public static void main(String[] args) {
    }
}