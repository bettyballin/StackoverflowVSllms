import java.util.ArrayList;
import java.util.List;

public class Main_45_45 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println("Before: " + list.size());
        list.clear();
        System.out.println("After: " + list.size());
    }
}