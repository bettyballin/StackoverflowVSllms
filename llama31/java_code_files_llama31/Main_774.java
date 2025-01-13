/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main_774 {
    public static <T> void shuffleList(List<T> list) {
        Random random = new Random();
        for (int i = list.size() - 1; i > 0; --i) {
            int n = random.nextInt(i + 1);
            T t = list.get(n);
            list.set(n, list.get(i));
            list.set(i, t);
        }
    }

    public static void main(String[] stringArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        System.out.println("Before shuffling: " + String.valueOf(arrayList));
        Main_774.shuffleList(arrayList);
        System.out.println("After shuffling: " + String.valueOf(arrayList));
    }
}
