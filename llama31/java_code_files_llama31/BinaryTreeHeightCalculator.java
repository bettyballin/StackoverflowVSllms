/*
 * Decompiled with CFR 0.152.
 */
public class BinaryTreeHeightCalculator {
    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(this.getHeight(node.left), this.getHeight(node.right));
    }

    public static void main(String[] stringArray) {
        BinaryTreeHeightCalculator binaryTreeHeightCalculator = new BinaryTreeHeightCalculator();
        Node node = new Node();
        node.left = new Node();
        node.right = new Node();
        node.left.left = new Node();
        int n = binaryTreeHeightCalculator.getHeight(node);
        System.out.println("Height of the binary tree: " + n);
    }
}
