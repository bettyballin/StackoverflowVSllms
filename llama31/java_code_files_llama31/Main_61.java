/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Main_61 {
    public static void main(String[] stringArray) {
        ArrayList<Cat> arrayList = new ArrayList<Cat>();
        arrayList.add(new Cat(new Date(82, 0, 1)));
        arrayList.add(new Cat(new Date(83, 0, 24)));
        arrayList.add(new Cat(new Date(83, 0, 24)));
        arrayList.add(new Cat(new Date(84, 0, 1)));
        Collections.sort(arrayList, new Comparator<Cat>(){

            @Override
            public int compare(Cat cat, Cat cat2) {
                return cat.getBirthday().compareTo(cat2.getBirthday());
            }
        });
        Date date = new Date(83, 0, 24);
        int n = Collections.binarySearch(arrayList, new Cat(date), new Comparator<Cat>(){

            @Override
            public int compare(Cat cat, Cat cat2) {
                return cat.getBirthday().compareTo(cat2.getBirthday());
            }
        });
        if (n >= 0) {
            int n2 = n;
            while (n2 + 1 < arrayList.size() && ((Cat)arrayList.get(n2 + 1)).getBirthday().equals(date)) {
                ++n2;
            }
            List list = arrayList.subList(n, n2 + 1);
            System.out.println("Cats born on target birthday: " + list.size());
        } else {
            System.out.println("No cats born on target birthday");
        }
    }
}
