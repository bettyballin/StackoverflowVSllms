/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeBuilder {
    public static List<Node> buildTrees(List<Node> list) {
        HashMap<Integer, Node> hashMap = new HashMap<Integer, Node>();
        for (Node object : list) {
            hashMap.put(object.ID, object);
        }
        for (Node node : list) {
            Node node2;
            if (node.ParentID == null || (node2 = (Node)hashMap.get(node.ParentID)) == null) continue;
            node2.children.add(node);
        }
        ArrayList arrayList = new ArrayList();
        for (Node node2 : hashMap.values()) {
            if (node2.ParentID != null && hashMap.containsKey(node2.ParentID)) continue;
            arrayList.add(node2);
        }
        return arrayList;
    }

    public static void main(String[] stringArray) {
        ArrayList<Node> arrayList = new ArrayList<Node>();
        arrayList.add(new Node(1, null));
        arrayList.add(new Node(2, Integer.valueOf(1)));
        arrayList.add(new Node(3, Integer.valueOf(1)));
        arrayList.add(new Node(4, Integer.valueOf(2)));
        arrayList.add(new Node(5, Integer.valueOf(3)));
        List<Node> list = TreeBuilder.buildTrees(arrayList);
        System.out.println("Root nodes: " + String.valueOf(list));
    }
}
