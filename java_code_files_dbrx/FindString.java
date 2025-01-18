import java.util.*;

public class FindString {

    private static final List<Character> ALPHABET;

    static {
        ALPHABET = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            ALPHABET.add(c);
        }
    }

    private String secret = "secret"; // You can set this to your desired secret string

    public List<Character> wildcard(String prefix) {
        List<Character> matches = new ArrayList<>();

        for (char c : ALPHABET) { // Assume ALPHABET is your character set, 'a'...'z', or all ASCII chars etc.
            if (doesWildcardMatch(prefix + "*" + c)) {
                matches.add(c);
            }
        }

        return matches;
    }

    private boolean doesWildcardMatch(String pattern) {
        // Simple pattern match where '*' matches any sequence
        String regex = pattern.replace("*", ".*");
        return secret.matches(regex);
    }

    public void findString() {
        // Start with a single wildcard character
        String prefix = new StringBuilder().append("*").toString();

        while (true) {
            List<Character> matches = wildcard(prefix);

            if (matches.size() == 1) {
                prefix += "*" + matches.get(0); // Add this char to the end of our prefix
                continue;
            } else if (matches.isEmpty()) {
                break; // No further matches found, string is empty.
            } else {
                int divPoint = matches.size() / 2;

                String p1 = new StringBuilder().append(prefix).append("*").toString();
                String p2 = new StringBuilder()
                    .append(matches.get(divPoint))
                    .append("*")
                    .append(p1)
                    .append(ALPHABET.subList(divPoint + 1, ALPHABET.size()).toString())
                    .toString();
                // Further processing can be added here if needed.
            }
        }
    }

    public static void main(String[] args) {
        new FindString().findString();
    }
}