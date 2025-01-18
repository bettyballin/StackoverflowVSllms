import java.util.List;
import java.util.LinkedList;
import java.util.LinkedHashSet;

public class ListUtil {
    List<Integer> yourOriginalList = new LinkedList<Integer>();
    List<Integer> listWithoutDuplicates = new LinkedList<Integer>(new LinkedHashSet<Integer>(yourOriginalList));

    public static void main(String[] args) {
    }
}