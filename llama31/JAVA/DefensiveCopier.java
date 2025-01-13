import java.util.List;
import java.util.ArrayList;

public class DefensiveCopier {
    public void someFunction(List myList){
        List myList2 = new ArrayList<>(myList); // defensive copy
        // work with myList2
    }

    public static void main(String[] args) {
        DefensiveCopier dc = new DefensiveCopier();
        List<String> list = new ArrayList<>();
        dc.someFunction(list);
    }
}