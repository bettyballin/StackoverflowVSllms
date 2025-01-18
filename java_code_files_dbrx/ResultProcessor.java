import java.util.*;
import java.util.stream.*;

public class ResultProcessor {
    List<Result> resultList = new ArrayList<>();

    List<Map.Entry<Integer, List<String>>> entries = resultList
            .stream()
            .collect(Collectors.groupingBy(Result::getId)) // groups them by id
            .entrySet()
            .stream()
            .map(e -> {
                Map.Entry<Integer, List<String>> nestedMap = new AbstractMap.SimpleImmutableEntry<>(
                    e.getKey(),
                    e.getValue().stream().map(Result::getValue).collect(Collectors.toList())); // maps the list of entities to their values
                return nestedMap;
            })
            .collect(Collectors.toList());

    public static void main(String[] args) {
    }
}

class Result {
    private int id;
    private String value;

    public Result(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() { return id; }
    public String getValue() { return value; }
}