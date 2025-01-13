import java.lang.String;
import java.util.TreeMap;

public class Main_392 {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("banana", "fruit");
        treeMap.put("apple", "fruit");
        treeMap.put("dog", "animal");

        for (String key : treeMap.keySet()) {
            System.out.println(key);
        }
    }
}