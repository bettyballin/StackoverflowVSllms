import java.util.List;
import java.util.ArrayList;

public class ListSplitter {
    public <T> List<T> split(List<T> list, int i) {
        List<T> secondHalf = new ArrayList<>(list.subList(i, list.size()));
        list.subList(i, list.size()).clear();
        return secondHalf;
    }

    public static void main(String[] args) {
    }
}