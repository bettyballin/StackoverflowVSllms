import java.lang.String;
import java.util.Set;
import java.util.HashSet;
import java.util.Optional;

public class FirstElementFinder {
    Set<String> set = new HashSet<>();
    // Assume set is populated
    Optional<String> firstElement = set.stream().findFirst();

    public static void main(String[] args) {
    }
}