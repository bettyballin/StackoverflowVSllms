import java.util.List;
import java.util.ArrayList;

public class MyClass {

    public List<Long> toIdsList(List<ViewValue> viewValues) {
        List<Long> ids = new ArrayList<Long>();
        for (ViewValue value : viewValues) {
            ids.add(value.getId());
        }
        return ids;
    }

    public static class ViewValue {
        private Long id;

        public ViewValue(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
    }
}