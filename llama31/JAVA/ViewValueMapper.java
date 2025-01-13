import java.util.List;
import java.util.stream.Collectors;

public class ViewValueMapper {
    List<Long> toIdsList(List<ViewValue> viewValues) {
        return viewValues.stream()
                .map(ViewValue::getId)
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
    }
}

class ViewValue {
    private Long id;

    public Long getId() {
        return id;
    }
}