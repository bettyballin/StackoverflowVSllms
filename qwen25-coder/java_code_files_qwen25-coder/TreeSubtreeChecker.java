import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class TreeNode<T> {
    T value;
    List<TreeNode<T>> children = new ArrayList<>();

    TreeNode(T value) {
        this.value = value;
    }

    boolean isSubtree(TreeNode<T> other) {
        if (!value.equals(other.value)) {
            return false;
        }
        if (other.children.size() != children.size()) {
            return false;
        }
        for (int i = 0; i < children.size(); i++) {
            if (!children.get(i).isSubtree(other.children.get(i))) {
                return false;
            }
        }
        return true;
    }
}

public class TreeSubtreeChecker {

    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<>("A");
        TreeNode<String> b = new TreeNode<>("B");
        TreeNode<String> a1 = new TreeNode<>("A");
        TreeNode<String> a2 = new TreeNode<>("A");

        root.children.add(b);
        b.children.add(a1);
        a1.children.addAll(Arrays.asList(new TreeNode<>("A"), new TreeNode<>("A")));

        TreeNode<String> subRoot = new TreeNode<>("A");
        subRoot.children.addAll(Arrays.asList(new TreeNode<>("A"), new TreeNode<>("A")));

        System.out.println(root.isSubtree(subRoot)); // prints true or false depending on the structure
    }
}