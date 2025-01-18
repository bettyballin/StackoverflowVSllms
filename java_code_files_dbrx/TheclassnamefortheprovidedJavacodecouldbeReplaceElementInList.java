import java.lang.String;
import java.lang.Integer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class TheclassnamefortheprovidedJavacodecouldbeReplaceElementInList {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>(Arrays.asList(10, 20, 30));
        ListIterator<Integer> itr = myList.listIterator();
        while (itr.hasNext()) {
            Integer oldValue = itr.next();
            if (oldValue.equals(20)) { // replace '20' with '45'
                Integer removedElement = null;
                while (itr.hasPrevious()) {
                    removedElement = itr.previous();
                    if (removedElement.equals(oldValue)) {
                        break;
                    }
                    itr.next(); // to take to the next element after your replaced integer.
                }
                // now remove that int and add back with new value
                itr.remove();
                myList.add(itr.nextIndex(), 45); // replace 'oldvalue' index position to new value(45)
            }
        }
    }
}