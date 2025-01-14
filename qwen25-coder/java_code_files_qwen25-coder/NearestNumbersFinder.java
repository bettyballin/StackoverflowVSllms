import java.lang.String;
import java.lang.Integer;
import java.util.TreeSet;

public class NearestNumbersFinder {
    private TreeSet<Integer> numbers;

    public NearestNumbersFinder() {
        numbers = new TreeSet<>();
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public Integer findNextSmallest(int target) {
        return numbers.lower(target); // Returns the greatest element less than the specified element
    }

    public Integer findNextLargest(int target) {
        return numbers.higher(target); // Returns the least element greater than the specified element
    }

    public static void main(String[] args) {
        NearestNumbersFinder finder = new NearestNumbersFinder();
        finder.addNumber(60);
        finder.addNumber(68);

        int targetDate = 2; // Assuming dates are converted to a comparable integer format
        Integer nextSmallest = finder.findNextSmallest(targetDate);
        Integer nextLargest = finder.findNextLargest(targetDate);

        System.out.println("Next Smallest: " + nextSmallest);
        System.out.println("Next Largest: " + nextLargest);
    }
}