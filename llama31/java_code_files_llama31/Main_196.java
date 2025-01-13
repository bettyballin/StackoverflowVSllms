/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.List;

public class Main_196 {
    public static void main(String[] stringArray) {
        List<Edge> list = Arrays.asList(new Edge(0, 1, 2), new Edge(0, 2, 3), new Edge(1, 2, 1), new Edge(1, 3, 4), new Edge(2, 3, 2));
        List<Edge> list2 = Kruskal.kruskal(list, 4);
        System.out.println(list2);
    }
}
