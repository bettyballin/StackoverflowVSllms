import java.util.*;

public class Main_420_420 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key1", "value3"); // override value1

        List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> {
            int keyCompare = o1.getKey().compareTo(o2.getKey());
            if (keyCompare == 0) {
                return o1.getValue().compareTo(o2.getValue());
            } else {
                return keyCompare;
            }
        });

        for (Map.Entry<String, String> entry : list) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}