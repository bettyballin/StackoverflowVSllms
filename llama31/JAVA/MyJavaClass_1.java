import java.util.Hashtable;

public class MyJavaClass_1 {
    private static Hashtable<String, String> myTable = new Hashtable<String, String>();

    public static void main(String[] args) {
        // ... use myTable ...
        // Example usage
        myTable.put("key1", "value1");
        System.out.println(myTable.get("key1"));
    }
}