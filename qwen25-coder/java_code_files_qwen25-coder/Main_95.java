import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<MyObject> list = new ArrayList<>();
        
        ImmutableList<MyObject> immutableList = ImmutableList.copyOf(list);
    }
}

class MyObject {
    // Class definition for MyObject
}