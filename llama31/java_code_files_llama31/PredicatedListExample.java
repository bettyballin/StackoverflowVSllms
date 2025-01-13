/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicatedListExample {
    public static void main(String[] stringArray) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        List list = arrayList.stream().filter(Predicate.not(object -> object == null)).collect(Collectors.toList());
        System.out.println("List size after filtering null: " + list.size());
    }
}
