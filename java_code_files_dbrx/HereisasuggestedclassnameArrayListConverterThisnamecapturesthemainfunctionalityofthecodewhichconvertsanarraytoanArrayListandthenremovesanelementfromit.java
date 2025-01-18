import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HereisasuggestedclassnameArrayListConverterThisnamecapturesthemainfunctionalityofthecodewhichconvertsanarraytoanArrayListandthenremovesanelementfromit {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4}; // Array of integers
        // Convert to ArrayList
        List<Integer> listOfNumbers = Arrays.stream(arr).collect(Collectors.toList());

        // Remove the number at index 2 (third element)
        listOfNumbers.remove(2);
    }
}