import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Main_774 {

    public static <T> void shuffleList(List<T> list) {
        Random rand = new Random();
        for (int i = list.size() - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            T temp = list.get(index);
            list.set(index, list.get(i));
            list.set(i, temp);
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("Before shuffling: " + list);
        shuffleList(list);
        System.out.println("After shuffling: " + list);
    }
}