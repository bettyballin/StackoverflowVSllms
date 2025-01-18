import java.lang.String;
import java.util.*;

public class CaseInsensitiveComparator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(final String o1, final String o2) {
                return o1.toUpperCase().compareTo(o2.toUpperCase());
            }
        });
    }
}