import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JTree;
import javax.swing.SwingUtilities;

public class TreeNodeAdder {
    private DefaultTreeModel model;
    private DefaultMutableTreeNode root;
    private JTree tree;

    public TreeNodeAdder() {
        root = new DefaultMutableTreeNode("Root");
        model = new DefaultTreeModel(root);
        tree = new JTree(model);
        addNodes();
    }

    private void addNodes() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    final MutableTreeNode child = new DefaultMutableTreeNode("test");
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            model.insertNodeInto(child, root, root.getChildCount());
                            tree.expandRow(tree.getRowCount() - 1);
                        }
                    });
                    // You can add a small delay here if you want to control the rate of node addition
                    try {
                        Thread.sleep(100); // 100ms delay
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new TreeNodeAdder();
    }
}