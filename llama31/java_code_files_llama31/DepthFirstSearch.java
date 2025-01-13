/*
 * Decompiled with CFR 0.152.
 */
public class DepthFirstSearch {
    private static void dfs(Node node, boolean[] blArray) {
        blArray[node.getIndex()] = true;
        System.out.print(node.getValue() + " ");
        for (Node node2 : node.getNeighbors()) {
            if (blArray[node2.getIndex()]) continue;
            DepthFirstSearch.dfs(node2, blArray);
        }
    }

    public static void main(String[] stringArray) {
        Node[] nodeArray = new Node[]{new Node(0, "A"), new Node(1, "B"), new Node(2, "C"), new Node(3, "D"), new Node(4, "E")};
        nodeArray[0].addNeighbor(nodeArray[1]);
        nodeArray[0].addNeighbor(nodeArray[2]);
        nodeArray[1].addNeighbor(nodeArray[3]);
        nodeArray[2].addNeighbor(nodeArray[4]);
        boolean[] blArray = new boolean[nodeArray.length];
        DepthFirstSearch.dfs(nodeArray[0], blArray);
    }
}
