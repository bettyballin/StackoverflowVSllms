import java.util.ArrayList;
import java.util.List;

public class FixedSizeStringArrayvsDynamicSizeStringList {
    String[] stringArray = new String[1000];  // Initialize capacity. Exceeding this will throw exception
    List<String> stringList = new ArrayList<>(); // No need to specify initial size as it grows automatically when size exceeds limit

    public static void main(String[] args) {
    }
}