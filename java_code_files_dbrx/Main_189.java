import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();

        // Add some numbers to the list
        listOfNumbers.add(1);
        listOfNumbers.add(2);
        listOfNumbers.add(3);

        listOfNumbers.remove((Integer)2);  // Removes '2' from ArrayList listOfNumbers

        // Print the list to verify
        System.out.println(listOfNumbers);
    }
}