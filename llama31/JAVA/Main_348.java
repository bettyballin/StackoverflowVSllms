import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main_348 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        List<String> replacedList = list.stream()
                .map(s -> s.equals("B") ? "X" : s)
                .collect(Collectors.toList());

        System.out.println(replacedList); // prints [A, X, C]
    }
}