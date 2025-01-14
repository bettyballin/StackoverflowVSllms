import java.util.*;

public class OAuthSortExample {
    public static void main(String[] args) {
        // Sample list of key-value pairs
        List<Map.Entry<String, String>> keyValuePairs = new ArrayList<Map.Entry<String, String>>();
        keyValuePairs.add(new AbstractMap.SimpleEntry<String, String>("key2", "value1"));
        keyValuePairs.add(new AbstractMap.SimpleEntry<String, String>("key1", "value3"));
        keyValuePairs.add(new AbstractMap.SimpleEntry<String, String>("key1", "value2"));

        // Sort primarily by key, secondarily by value
        Collections.sort(keyValuePairs, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                int cmpKey = o1.getKey().compareTo(o2.getKey());
                if (cmpKey == 0) {
                    return o1.getValue().compareTo(o2.getValue());
                }
                return cmpKey;
            }
        });

        // Print sorted list
        for (Map.Entry<String, String> entry : keyValuePairs) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}