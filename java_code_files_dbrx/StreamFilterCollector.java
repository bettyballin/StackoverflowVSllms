import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class StreamFilterCollector {

    List<MyObject> myArrayList = new ArrayList<>();
    Map<String, MyObject> myHashMap = new HashMap<>();

    List<MyObject> filteredList = myArrayList.stream()
                             .filter(obj -> obj.getField().matches("your pattern"))
                             .collect(Collectors.toList());

    List<Map.Entry<String, MyObject>> filteredEntries = myHashMap.entrySet().stream()
                              .filter(entry -> entry.getValue().getField().matches("your pattern"))
                              .collect(Collectors.toList());

    public static void main(String[] args) {
    }
}

class MyObject {
    public String getField() {
        return "";
    }
}