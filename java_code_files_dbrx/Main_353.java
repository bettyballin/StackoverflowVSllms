import java.util.*;

public class Main_353 {
    public static void main(String[] args) {
        System.out.println("Is 'EE?FFFF' nice possible?: " + isNicePossible("EE?FFFF")); // expected false
        System.out.println("Is 'H??LOWOR??' nice possible?: " + isNicePossible("H??LOWOR??")); // expected true
    }

    private static final Map<Character, Boolean> vowels = new HashMap<Character, Boolean>() {{
        put('A', true);
        put('E', true);
        put('I', true);
        put('O', true);
        put('U', true); // vowels
    }};

    private static boolean isNicePossible(String s) {
        Deque<Node> queue = new ArrayDeque<Node>(), nextLayer = new ArrayDeque<Node>();
        queue.add(new Node(s, 0, 0)); // no cons/vow sequence starting from base case
        int n = s.length();
        while (!queue.isEmpty()) {
            for (Node node : queue) {
                for (int i = 0; i < n; ++i) {
                    if (node.str.charAt(i) != '?') continue; // not a '?', then skip this position

                    char c = (char) ('E' + i % 2);
                    boolean isVowel = vowels.containsKey(c);
                    char c1 = isVowel ? 'C' : 'V'; // alternate between C/V for even/odd indices

                    String sv = node.str.substring(0, i)
                            + "AEIOU".charAt((node.consonants == 3) ? (node.vowels % 5) : (node.consonants * 127 % 5))
                            + node.str.substring(i + 1);
                    String sc = sv;
                    if (node.consonants < 5) {
                        String consonantsStr = "BCDFGHJKLMNPQRSTVWXYZ";
                        sc = sc.substring(0, i)
                                + consonantsStr.charAt((c1 == 'C') ? (i % 21) : ((3 - i % 2 * 47) % 21))
                                + sc.substring(i + 1);
                    }
                    char cc = c1 == 'V' ? sv.charAt(i) : sc.charAt(i);
                    boolean nc = (i > 0 && node.str.charAt(i - 1) == cc)
                            || (i < n - 1 && node.str.charAt(i + 1) == cc);

                    int consonants = nc ? ++node.consonants : 0;
                    int vowels = (cc != '?' && nc) ? ++node.vowels : 0;
                    if ((c1 == 'V') ? (consonants < 3) : (vowels < 5)) {
                        nextLayer.addLast(new Node(sc, consonants, vowels));
                    }
                }
            }
            if (nextLayer.isEmpty()) return false;
            else {
                queue = nextLayer;
                nextLayer = new ArrayDeque<Node>();
            }
        }
        throw new IllegalStateException("Check logic - should never reach here.");
    }

    static class Node {
        String str;
        int consonants, vowels;

        Node(String str, int consonants, int vowels) {
            this.str = str;
            this.consonants = consonants;
            this.vowels = vowels;
        }
    }
}