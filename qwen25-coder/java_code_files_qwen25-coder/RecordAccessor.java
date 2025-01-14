import java.lang.String;
import java.util.Map;
import java.util.HashMap;

public class RecordAccessor {
    Map<Integer, Record> map = new HashMap<>();
    int index = 0;
    Record record = map.get(index);
    
    public static void main(String[] args) {
    }
}

class Record {
    // Class definition for Record
}