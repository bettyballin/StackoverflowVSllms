import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.CollectionUtils;

public class SilentPredicatedList<T> extends ArrayList<T> {
    private final Predicate<? super T> predicate;

    public SilentPredicatedList(Predicate<? super T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean add(final T object) {
        if (CollectionUtils.exists(Collections.singleton(object), predicate)) {
            return super.add(object);
        }
        return false;
    }

    public static void main(String[] args) {
    }
}