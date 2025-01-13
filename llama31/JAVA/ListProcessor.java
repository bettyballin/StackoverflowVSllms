import java.util.List;
import java.util.ArrayList;

class MyType {}

public class ListProcessor {
    public <T extends MyType> void processList(List<T> list, T instance) {
        list.add(instance);
    }

    public static void main(String[] args) {
        ListProcessor processor = new ListProcessor();
        List<MyType> list = new ArrayList<>();
        MyType instance = new MyType();
        processor.processList(list, instance);
    }
}