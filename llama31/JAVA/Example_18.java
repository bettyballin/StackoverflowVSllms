import java.util.ArrayList;

public class Example_18_18 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();

        // add elements
        myList.add("apple");
        myList.add("banana");
        myList.add("cherry");

        // retrieve elements
        String fruit = myList.get(0);
        System.out.println(fruit); // prints "apple"
    }
}