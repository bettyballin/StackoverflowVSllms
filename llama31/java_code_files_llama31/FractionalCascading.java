/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FractionalCascading {
    private List<List<Integer>> lists;
    private List<List<Integer>> bridges;

    public FractionalCascading(List<List<Integer>> list) {
        this.lists = list;
        this.bridges = new ArrayList<List<Integer>>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); ++i) {
            arrayList.add(list.get(i).get(0));
            this.bridges.add(new ArrayList());
            this.bridges.get(i).add(list.get(i).get(1));
        }
        this.createBridges(arrayList, this.bridges, 1);
    }

    private void createBridges(List<Integer> list, List<List<Integer>> list2, int n) {
        if (n >= this.lists.size()) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); ++i) {
            arrayList.add(list2.get(i).get(n - 1));
            if (n >= this.lists.get(i).size()) continue;
            list2.get(i).add(this.lists.get(i).get(n));
        }
        this.createBridges(arrayList, list2, n + 1);
    }

    public List<Integer> locate(int[] nArray) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int n : nArray) {
            int n2 = Collections.binarySearch(this.lists.get(0), n);
            if (n2 < 0) continue;
            arrayList.add(n2);
            for (int i = 1; i < this.lists.size(); ++i) {
                n2 = this.bridges.get(i - 1).get(n2);
                arrayList.add(n2);
            }
        }
        return arrayList;
    }

    public static void main(String[] stringArray) {
        ArrayList<List<Integer>> arrayList = new ArrayList<List<Integer>>();
        arrayList.add(Arrays.asList(1, 3, 5));
        arrayList.add(Arrays.asList(2, 4, 6));
        arrayList.add(Arrays.asList(7, 8, 9));
        FractionalCascading fractionalCascading = new FractionalCascading(arrayList);
        int[] nArray = new int[]{3, 6};
        System.out.println(fractionalCascading.locate(nArray));
    }
}
