import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class AnimalFilter {
    public static void main(String[] args) {
        // Assuming animsContext is an instance of a class that provides an iterate method
        // You need to replace this with your actual implementation
        AnimalContext animsContext = new AnimalContext();

        Iterator<Animal> iter = animsContext.iterate("/.[type='CAT']");
        List<Animal> cats = new ArrayList<Animal>();
        while(iter.hasNext()){
            cats.add(iter.next());
        }
    }
}

// You need to define the Animal and AnimalContext classes
class Animal {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class AnimalContext {
    public Iterator<Animal> iterate(String query) {
        // You need to implement the logic to iterate over animals based on the query
        // For now, it returns an empty iterator
        return new ArrayList<Animal>().iterator();
    }
}