import java.util.List;
import java.util.Arrays;
import java.util.ListIterator;

public class IteratorHelperorListModifier {
    public static void main(String[] args) {
        List<Integer> myNewList = Arrays.asList(10, 20, 30);
        for (ListIterator<Integer> itr = myNewList.listIterator(); itr.hasNext();) {
            int oldValue = itr.next();
            if (oldValue == 20) { //replace '20' with '45'
                oldValue = itr.nextIndex() + 1;
                int replacement = 45;
                myNewList.set(itr.previousIndex(), replacement);
            }
        }
    }
}