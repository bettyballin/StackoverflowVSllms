import java.util.List;

public class Example_14 {
    public static <T> T getLastElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is empty or not initialized");
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        List<String> myList = List.of("a", "b", "c");
        System.out.println(getLastElement(myList)); // Output: c
    }
}