import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ViewIdExtractor {
    List<ViewValue> viewValues = new ArrayList<>();

    List<Long> ids = viewValues.stream()
                               .map(ViewValue::getId)
                               .collect(Collectors.toList());
    public static void main(String[] args) {
    }
}

class ViewValue {
    private Long id;

    public ViewValue(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}