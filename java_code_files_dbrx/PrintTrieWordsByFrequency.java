import java.lang.String;
import java.lang.Integer;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class PrintTrieWordsByFrequency {
    static class TrieNode {
        int count;
        char ch;
        String word;
        Map<Character, TrieNode> children = new HashMap<>();
    }
    
    static TrieNode root = new TrieNode();
    
    public static void main(String[] args) {
        PriorityQueue<TrieNode> heap = new PriorityQueue<>((a, b) -> {
            if(a.count != b.count){
                return Integer.compare(b.count, a.count);
            } else {
                return Integer.compare(a.ch, b.ch); // for alphabetical order in case of the same frequency
            }
        });
        heap.addAll(root.children.values());
        while (!heap.isEmpty()) {
            TrieNode current = heap.poll();
            System.out.println("Word: " + current.word + ", Frequency: " + current.count);
        }
    }
}