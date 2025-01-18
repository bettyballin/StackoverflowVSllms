import java.lang.String;
import java.lang.Integer;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ElementReplacer {

    List<Integer> myList = new ArrayList<>();
    Integer oldValue = 0;
    Integer replacement = 0;

    List<Integer> myNewList = myList.stream()
        .map(i -> i == oldValue ? replacement : i)
        .collect(Collectors.toList());

    public static void main(String[] args) {
    }
}