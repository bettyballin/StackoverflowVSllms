import java.util.*;

class TrieNode {
    Map<String, TrieNode> children;
    List<String> completionCandidates;

    public TrieNode() {
        children = new HashMap<>();
        completionCandidates = new ArrayList<>();
    }
}

class CodeCompletion {
    private TrieNode root;

    public CodeCompletion() {
        root = new TrieNode();
    }

    public void addCompletionCandidate(String prefix, String candidate) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.computeIfAbsent(String.valueOf(c), k -> new TrieNode());
        }
        node.completionCandidates.add(candidate);
    }

    public List<String> getCompletionCandidates(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(String.valueOf(c));
            if (node == null) return Collections.emptyList();
        }
        return node.completionCandidates;
    }
}

public class Main {
    public static void main(String[] args) {
        CodeCompletion cc = new CodeCompletion();
        cc.addCompletionCandidate("he", "hello");
        cc.addCompletionCandidate("he", "help");
        cc.addCompletionCandidate("ho", "house");
        System.out.println(cc.getCompletionCandidates("he"));
        System.out.println(cc.getCompletionCandidates("ho"));
        System.out.println(cc.getCompletionCandidates("hi"));
    }
}