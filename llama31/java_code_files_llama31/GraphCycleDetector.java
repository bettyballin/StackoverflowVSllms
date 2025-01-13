/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class GraphCycleDetector {
    public boolean hasCycle(List<List<Integer>> list) {
        int[] nArray = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            if (nArray[i] != 0 || this.topologicalSortUtil(list, i, nArray)) continue;
            return true;
        }
        return false;
    }

    private boolean topologicalSortUtil(List<List<Integer>> list, int n, int[] nArray) {
        nArray[n] = 1;
        for (int n2 : list.get(n)) {
            if (nArray[n2] == 1) {
                return false;
            }
            if (nArray[n2] != 0 || this.topologicalSortUtil(list, n2, nArray)) continue;
            return false;
        }
        nArray[n] = 2;
        return true;
    }

    public static void main(String[] stringArray) {
        GraphCycleDetector graphCycleDetector = new GraphCycleDetector();
        ArrayList<List<Integer>> arrayList = new ArrayList<List<Integer>>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(1);
        arrayList2.add(2);
        arrayList.add(arrayList2);
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        arrayList3.add(2);
        arrayList.add(arrayList3);
        ArrayList<Integer> arrayList4 = new ArrayList<Integer>();
        arrayList4.add(0);
        arrayList.add(arrayList4);
        System.out.println(graphCycleDetector.hasCycle(arrayList));
    }
}
