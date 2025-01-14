import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Cat {
    private final LocalDate birthDate;

    public Cat(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}

public class CatFinder {

    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        // Assume 'cats' is sorted by their birth dates
        cats.sort(Comparator.comparing(Cat::getBirthDate));

        LocalDate targetBirthday = LocalDate.of(1983, 1, 24);
        findCatsWithBirthday(cats, targetBirthday).forEach(cat -> 
            System.out.println("Cat with birthday on " + cat.getBirthDate())
        );
    }

    public static List<Cat> findCatsWithBirthday(List<Cat> cats, LocalDate date) {
        int start = Collections.binarySearch(
                cats,
                new Cat(date),
                Comparator.comparing(Cat::getBirthDate)
        );

        if (start < 0) return new ArrayList<>(); // No match found

        // Adjust start to the first occurrence
        while (start > 0 && cats.get(start - 1).getBirthDate().equals(date)) {
            start--;
        }

        int end = start;
        // Find the last occurrence
        while (end < cats.size() && cats.get(end).getBirthDate().equals(date)) {
            end++;
        }

        return cats.subList(start, end);
    }
}