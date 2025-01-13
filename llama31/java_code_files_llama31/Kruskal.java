/*
 * Decompiled with CFR 0.152.
 */
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Kruskal {
    Kruskal() {
    }

    public static List<Edge> kruskal(List<Edge> list, int n) {
        list.sort((Comparator)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)I, compareTo(Edge ), (LEdge;LEdge;)I)());
        int[] nArray = new int[n];
        for (int i = 0; i < n; ++i) {
            nArray[i] = i;
        }
        ArrayList<Edge> arrayList = new ArrayList<Edge>();
        for (Edge edge : list) {
            if (Kruskal.find(nArray, (int)edge.source) == Kruskal.find(nArray, (int)edge.destination)) continue;
            Kruskal.union(nArray, (int)edge.source, (int)edge.destination);
            arrayList.add(edge);
        }
        return arrayList;
    }

    private static int find(int[] nArray, int n) {
        if (nArray[n] != n) {
            nArray[n] = Kruskal.find(nArray, nArray[n]);
        }
        return nArray[n];
    }

    private static void union(int[] nArray, int n, int n2) {
        int n3;
        int n4 = Kruskal.find(nArray, n);
        nArray[n4] = n3 = Kruskal.find(nArray, n2);
    }
}
