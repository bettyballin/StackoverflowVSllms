import java.lang.String;
import java.util.Stack;
import static java.lang.System.exit;
class Node{
    int data;
    Node left, right;
}
public class PostOrderIterative {
    public void printPostorder(Node node){
        if (node == null) return;
        Stack<Node> S1 = new Stack<>();
        Stack<Node> S2 = new Stack<>();
 	S1.push(node);
        while (!S1.empty()){
            node = S1.pop();
            S2.push(node);
            if (node.left != null)
                S1.push(node.left);
            if (node.right != null)
                S1.push(node.right);
        }
	while (!S2.empty()){
            node = S2.pop();
            System.out.print(node.data + " ");
        }
    }

	public static void main(String[] args) {
	}
}