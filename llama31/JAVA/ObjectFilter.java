import java.util.List;
import java.util.stream.Collectors;

class MyObject {
    private int someProperty;

    public int getSomeProperty() {
        return someProperty;
    }

    public void setSomeProperty(int someProperty) {
        this.someProperty = someProperty;
    }
}

public class ObjectFilter {
    public static void main(String[] args) {
        List<MyObject> myList = List.of(
            new MyObject() {{ setSomeProperty(1); }},
            new MyObject() {{ setSomeProperty(2); }},
            new MyObject() {{ setSomeProperty(1); }}
        );

        int someValue = 1;

        List<MyObject> filteredList = myList.stream()
            .filter(obj -> obj.getSomeProperty() == someValue)
            .collect(Collectors.toList());

        System.out.println(filteredList.size());
    }
}