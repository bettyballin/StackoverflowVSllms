import java.util.Hashtable;

public class MyClass {
    public static void main(String[] args) {
        // Local variable declaration
        Hashtable<String, String> myTable = new Hashtable<String, String>();
        myTable.put("key", "value");

        // Processing with myTable...

        // At the end of JSP execution, myTable is eligible for GC
    }
}