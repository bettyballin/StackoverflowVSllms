import java.util.Collection;
import java.util.ArrayList;

public class CollectionHolder {
    private volatile Collection<?> myCollection;

    public void init() {
        myCollection = new ArrayList<>();
        // Fill the collection here
    }

    public Collection<?> getMyCollection() {
        return myCollection;
    }

    public static void main(String[] args) {
        CollectionHolder holder = new CollectionHolder();
        holder.init();
        System.out.println(holder.getMyCollection());
    }
}