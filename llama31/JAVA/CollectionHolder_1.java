import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionHolder_1_1 {
    private Collection<?> myCollection;

    public void init() {
        myCollection = new CopyOnWriteArrayList<>();
        // Fill the collection here
    }

    public Collection<?> getMyCollection() {
        return myCollection;
    }

    public static void main(String[] args) {
    }
}