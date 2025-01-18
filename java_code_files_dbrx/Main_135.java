import java.util.*;
import java.util.stream.*;
public class Main_135 {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("a", "set", "of", "random", "words");
    int maxLength = list.stream()
      .mapToInt(String::length) // converts each String in the stream to its length
      .max() // terminal operation that returns an OptionalInt, which is either empty or contains the maximum value from all values passed to it by upstream operations
      .getAsInt(); // gets the int value as a primitive data type from the OptionalInt returned by max
    System.out.println(maxLength);  // prints: 6
  }
}