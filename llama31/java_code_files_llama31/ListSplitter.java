/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class ListSplitter {
    public <T> List<T> split(List<T> list, int n) {
        ArrayList<T> arrayList = new ArrayList<T>(list.subList(n, list.size()));
        list.subList(n, list.size()).clear();
        return arrayList;
    }

    public static void main(String[] stringArray) {
    }
}
