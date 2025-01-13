import java.util.HashSet;
import java.util.Set;

public class UniqueIndexFinder {
    public int firstUniqueIndex(String[] strings) {
        int minLength = Integer.MAX_VALUE;
        for (String s : strings) {
            minLength = Math.min(minLength, s.length());
        }

        for (int i = 0; i < minLength; i++) {
            Set<Character> set = new HashSet<>();
            for (String s : strings) {
                if (!set.add(s.charAt(i))) {
                    break; // duplicate found, increment i
                }
            }
            if (set.size() == strings.length) {
                return i; // all unique
            }
        }
        return -1; // no unique index found
    }

    public static void main(String[] args) {
        UniqueIndexFinder finder = new UniqueIndexFinder();
        String[] strings = {"hello", "world", "hellu"};
        System.out.println(finder.firstUniqueIndex(strings));
    }
}