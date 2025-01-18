import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        int n = 10; // n times write operation
        for(int i = 0; i < n; i++) { 
            list.add(new Object());
        }
        Iterator<Object> itr = list.iterator();
        while (itr.hasNext()) {  // read the elements using iterator
            System.out.println(itr.next());
        }
    }
}