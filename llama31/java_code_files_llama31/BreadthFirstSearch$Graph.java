/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

static class BreadthFirstSearch.Graph {
    private Map<Integer, List<Integer>> adjacencyList = new HashMap<Integer, List<Integer>>();

    public void addEdge(int n2, int n3) {
        this.adjacencyList.computeIfAbsent(n2, n -> new ArrayList()).add(n3);
        this.adjacencyList.computeIfAbsent(n3, n -> new ArrayList()).add(n2);
    }

    public List<List<Integer>> findPaths(int n, int n2) {
        ArrayList<List<Integer>> arrayList = new ArrayList<List<Integer>>();
        LinkedList<List<Integer>> linkedList = new LinkedList<List<Integer>>();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        linkedList.offer(Collections.singletonList(n));
        hashSet.add(n);
        while (!linkedList.isEmpty()) {
            List list = (List)linkedList.poll();
            int n3 = (Integer)list.get(list.size() - 1);
            if (n3 == n2) {
                arrayList.add(list);
                continue;
            }
            for (int n4 : this.adjacencyList.get(n3)) {
                if (hashSet.contains(n4)) continue;
                hashSet.add(n4);
                ArrayList<Integer> arrayList2 = new ArrayList<Integer>(list);
                arrayList2.add(n4);
                linkedList.offer(arrayList2);
            }
        }
        return arrayList;
    }
}
