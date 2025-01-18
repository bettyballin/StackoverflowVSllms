import java.util.*;

public class Main_1 {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        // add in order
        map.put(1, "one");
        map.put(2,"two");
        System.out.println("Printing using keys: "+map);  // Prints: {1=one, 2=two}

        int index = 0;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if(index == 1){
                System.out.println("Second element using an index position is: "+entry); // Prints second added element in the order.
                break;
            }
            index++;
        }
    }
}