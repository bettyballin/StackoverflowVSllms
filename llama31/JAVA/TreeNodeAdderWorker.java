import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JTree;

import java.util.List;

public class TreeNodeAdderWorker {
    private DefaultTreeModel model;
    private JTree tree;
    private MutableTreeNode root;

    public TreeNodeAdderWorker() {
        // Initialize tree model and tree
        root = new DefaultMutableTreeNode("Root");
        model = new DefaultTreeModel(root);
        tree = new JTree(model);
    }

    public void start() {
        SwingWorker<Void, MutableTreeNode> worker = new SwingWorker<Void, MutableTreeNode>() {
            @Override
            protected Void doInBackground() {
                while (true) {
                    final MutableTreeNode child = new DefaultMutableTreeNode("test");
                    publish(child);
                    // You can add a small delay here if you want to control the rate of node addition
                }
            }

            @Override
            protected void process(List<MutableTreeNode> chunks) {
                for (MutableTreeNode chunk : chunks) {
                    model.insertNodeInto(chunk, root, root.getChildCount());
                    tree.expandRow(tree.getRowCount() - 1);
                }
            }
        };
        worker.execute();
    }

    public static void main(String[] args) {
        TreeNodeAdderWorker worker = new TreeNodeAdderWorker();
        worker.start();
    }
}