class Node {
    int data;
    Node left, right;
}
public class segmentTree{
    private int arr[];

    private void build(int seg[], int low, int high, int pos) {
        if (low == high) {
            // Leaf node will have a single element.
            seg[pos] = arr[low];
            return;
        }
        Node left = new Node();
        Node right = new Node();
        build(seg, low, (low + high)/2, pos*2);   // Builds left subtree
        build(seg, (low + high)/2+1, high, pos*2+1); // Builds right subtree
    }

    public static void main(String[] args) {
    }
}