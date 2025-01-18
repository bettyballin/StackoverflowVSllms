import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("apple");
        myList.add("banana");
        myList.add("cherry");
        String separator = ", ";
        String result = String.join(separator, myList);
        System.out.println(result); // prints "apple, banana, cherry"
    }
}