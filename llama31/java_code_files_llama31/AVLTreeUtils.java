/*
 * Decompiled with CFR 0.152.
 */
public class AVLTreeUtils {
    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(this.getHeight(node.left), this.getHeight(node.right));
    }

    public int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return this.getHeight(node.left) - this.getHeight(node.right);
    }

    public static void main(String[] stringArray) {
        AVLTreeUtils aVLTreeUtils = new AVLTreeUtils();
        Node node = new Node();
        node.left = new Node();
        System.out.println(aVLTreeUtils.getBalanceFactor(node));
    }
}
