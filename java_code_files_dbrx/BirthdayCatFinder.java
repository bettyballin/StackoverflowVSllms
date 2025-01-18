import java.lang.String;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class BirthdayCatFinder {

    List<LocalDate> catsList = new ArrayList<>();

    {
        // Initialize catsList
        catsList.add(LocalDate.of(1980, 5, 12));
        catsList.add(LocalDate.of(1983, 1, 24));
        catsList.add(LocalDate.of(1985, 7, 19));
    }

    Comparator<LocalDate> comparatorLowerThanOrEquals = new Comparator<LocalDate>() {
        @Override
        public int compare(LocalDate d1, LocalDate d2) {
            return d1.compareTo(d2);
        }
    };

    LocalDate searchKey = LocalDate.of(1983, 1, 24);

    int lowerBoundIndex = Collections.binarySearch(catsList, searchKey, comparatorLowerThanOrEquals);

    // check if insertion position equals the index of an existing element
    int firstBirthdayCatIndex = (lowerBoundIndex < 0) ? ~lowerBoundIndex : lowerBoundIndex;

    public static void main(String[] args) {
        BirthdayCatFinder finder = new BirthdayCatFinder();
        System.out.println("First Birthday Cat Index: " + finder.firstBirthdayCatIndex);
    }
}