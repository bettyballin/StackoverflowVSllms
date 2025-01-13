import java.util.ArrayList;
import java.util.List;

public class ListSublist {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }

        int n = 10;

        for (int i = 0; i < list.size(); i += n) {
            System.out.println(list.get(i));
        }
    }
}