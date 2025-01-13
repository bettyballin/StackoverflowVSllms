/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

public class TreeNodeAdderWorker {
    private DefaultTreeModel model;
    private JTree tree;
    private MutableTreeNode root = new DefaultMutableTreeNode("Root");

    public TreeNodeAdderWorker() {
        this.model = new DefaultTreeModel(this.root);
        this.tree = new JTree(this.model);
    }

    public void start() {
        SwingWorker<Void, MutableTreeNode> swingWorker = new SwingWorker<Void, MutableTreeNode>(){

            @Override
            protected Void doInBackground() {
                while (true) {
                    DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("test");
                    this.publish(defaultMutableTreeNode);
                }
            }

            @Override
            protected void process(List<MutableTreeNode> list) {
                for (MutableTreeNode mutableTreeNode : list) {
                    TreeNodeAdderWorker.this.model.insertNodeInto(mutableTreeNode, TreeNodeAdderWorker.this.root, TreeNodeAdderWorker.this.root.getChildCount());
                    TreeNodeAdderWorker.this.tree.expandRow(TreeNodeAdderWorker.this.tree.getRowCount() - 1);
                }
            }
        };
        swingWorker.execute();
    }

    public static void main(String[] stringArray) {
        TreeNodeAdderWorker treeNodeAdderWorker = new TreeNodeAdderWorker();
        treeNodeAdderWorker.start();
    }
}
