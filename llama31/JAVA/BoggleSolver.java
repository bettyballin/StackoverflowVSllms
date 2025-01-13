import java.lang.String;
import java.lang.Map;
import java.lang.Set;
import java.lang.HashMap;
import java.io.*;
import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord;

    public TrieNode() {}
}

public class BoggleSolver {
    private TrieNode root;
    private char[][] grid;
    private int rows, cols;
    private Set<String> words = new HashSet<>();

    public BoggleSolver(char[][] grid, String[] dictionary) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.root = new TrieNode();
        buildTrie(dictionary);
    }

    private void buildTrie(String[] dictionary) {
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.isWord = true;
        }
    }

    public Set<String> findWords() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(i, j, root, new StringBuilder());
            }
        }
        return words;
    }

    private void dfs(int i, int j, TrieNode node, StringBuilder word) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '#') {
            return;
        }
        char c = grid[i][j];
        TrieNode next = node.children.get(c);
        if (next == null) {
            return;
        }
        word.append(c);
        if (next.isWord) {
            words.add(word.toString());
        }
        grid[i][j] = '#'; // mark as visited
        dfs(i - 1, j, next, word);
        dfs(i + 1, j, next, word);
        dfs(i, j - 1, next, word);
        dfs(i, j + 1, next, word);
        dfs(i - 1, j - 1, next, word);
        dfs(i - 1, j + 1, next, word);
        dfs(i + 1, j - 1, next, word);
        dfs(i + 1, j + 1, next, word);
        grid[i][j] = c; // reset
        word.deleteCharAt(word.length() - 1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'F', 'X', 'I', 'E'},
                {'A', 'M', 'L', 'O'},
                {'E', 'W', 'B', 'X'},
                {'A', 'S', 'T', 'U'}
        };
        String[] dictionary = {"LOB", "TUX", "SEA", "FAME"};
        BoggleSolver solver = new BoggleSolver(grid, dictionary);
        Set<String> words = solver.findWords();
        System.out.println(words);
    }
}