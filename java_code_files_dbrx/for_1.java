import java.lang.String;
public class for_1 {
    // Assuming we are working with this Node class for our Red-Black tree
    class Node{
        int key; // double precision - value can be easily adjusted
        char color; // 'R', 'B' for red or black node. Initially set as R(ed) when a new node is inserted into the tree.
        Node left, right, parent;

        public Node(int key){
            this.key = key;
            this.color = 'R';
        }
    }

    Node root; // Root of the tree

    // inserting an element in Red-Black Tree and maintaining its properties
    public void put(int key){
       if (root == null){
           root = new Node(key); //Create Node with default color: 'Red'
           return;
       }
       Node n, parentOfN; // n will hold the node during tree traversal.
                          // parentOfN acts similar to a trail for backtracking.
       parentOfN = null;
       n = root;
       while(n != null){  // Loop until leaf node reached
           parentOfN = n;
           if (key < n.key) {  // If key lesser, then proceed left of the tree. Else go right.
               n = n.left;
           } else if(key > n.key) {
               n = n.right;
           } else {
               break; // Key already exists in the tree
           }
       }
       // Code to insert the new node would be here
    }
    public static void main(String[] args) {
    }
}