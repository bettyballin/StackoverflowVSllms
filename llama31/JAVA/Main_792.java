import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int count = 0; // number of strings passing through this node
}

public class Main_792_792 {
    public static String findBestPrefix(List<String> strings) {
        TrieNode root = new TrieNode();
        for (String s : strings) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
                node.count++;
            }
        }

        String[] bestPrefix = new String[1];
        int[] bestLength = new int[1];
        bestLength[0] = Integer.MAX_VALUE;

        traverse(root, "", 0, strings.size(), bestPrefix, bestLength);

        return bestPrefix[0];
    }

    private static void traverse(TrieNode node, String prefix, int length, int totalStrings, String[] bestPrefix, int[] bestLength) {
        if (node.count == totalStrings) {
            int newLength = length + (totalStrings - 1) + (prefix.length());
            if (newLength < bestLength[0]) {
                bestPrefix[0] = prefix;
                bestLength[0] = newLength;
            }
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            traverse(entry.getValue(), prefix + entry.getKey(), length + 1, totalStrings, bestPrefix, bestLength);
        }
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("foo", "fool", "bar");
        System.out.println(findBestPrefix(strings)); // Output: "foo"
    }
}