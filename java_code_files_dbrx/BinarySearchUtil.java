import java.lang.String;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class BinarySearchUtil {

    public static void main(String[] args) {

        LocalDate searchKeyPlusOne = LocalDate.of(1983, 1, 25); // we want to find elements <= this date

        List<LocalDate> catsList = new ArrayList<>();

        Comparator<LocalDate> comparatorGreaterThanOrEquals = new Comparator<LocalDate>() {
            @Override
            public int compare(LocalDate d1, LocalDate d2) {
                return d1.compareTo(d2);
            }
        };

        int upperBoundIndex = Collections.binarySearch(catsList, searchKeyPlusOne, comparatorGreaterThanOrEquals);

        // check if insertion position equals the index of an existing non-matching element + 1
        int lastBirthdayCatIndexPlusOne = (upperBoundIndex < 0) ? ~upperBoundIndex : upperBoundIndex;
    }
}