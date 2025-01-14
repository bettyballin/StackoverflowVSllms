import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaseInsensitiveStringComparator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.sort(list, (String a, String b) -> 
            a.toUpperCase().compareTo(b.toUpperCase())
        );
    }
}