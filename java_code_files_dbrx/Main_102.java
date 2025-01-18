import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Map<Integer, ThreadInfo> myMap = new HashMap<>(); // Create a hashmap with keys as Integers representing thread IDs and values are your own class or data structure for storing thread information (ThreadInfo).
        //Adding info; '1234' is the id of current thread:
        myMap.put(1234, new InfoForTheThread()); //add a new entry into the HashMap where 1234 acts as the key to this value
        //Retrieve an existing entry for a certain thread ID:
        ThreadInfo info = myMap.get(123); // if 123 exists, it returns the corresponding ThreadInfo; otherwise, returns null
    }

    static class ThreadInfo {
        // Your own class or data structure for storing thread information
    }

    static class InfoForTheThread extends ThreadInfo {
        // Additional details for this specific thread
    }

}