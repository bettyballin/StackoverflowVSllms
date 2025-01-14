import java.util.ArrayList;

public class Example_23 {
    public static void main(String[] args) {
        // Create an ArrayList that holds Integer objects
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add elements to the ArrayList
        numbers.add(1); // Automatically boxes the primitive int into an Integer object
        numbers.add(2);
        numbers.add(3);

        // Access elements from the ArrayList
        System.out.println("First element: " + numbers.get(0));

        // The size of the ArrayList can change dynamically
        System.out.println("Size before adding more: " + numbers.size());
        numbers.add(4);
        System.out.println("Size after adding one more: " + numbers.size());

        // No need for explicit typecasting when retrieving elements
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }
}