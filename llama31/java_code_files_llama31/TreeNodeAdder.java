/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TreeNodeAdder {
    private DefaultTreeModel model;
    private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
    private JTree tree;

    public TreeNodeAdder() {
        this.model = new DefaultTreeModel(this.root);
        this.tree = new JTree(this.model);
        this.addNodes();
    }

    private void addNodes() {
        new Thread(new Runnable(){

            @Override
            public void run() {
                while (true) {
                    final DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode("test");
                    SwingUtilities.invokeLater(new Runnable(){

                        @Override
                        public void run() {
                            TreeNodeAdder.this.model.insertNodeInto(defaultMutableTreeNode, TreeNodeAdder.this.root, TreeNodeAdder.this.root.getChildCount());
                            TreeNodeAdder.this.tree.expandRow(TreeNodeAdder.this.tree.getRowCount() - 1);
                        }
                    });
                    try {
                        Thread.sleep(100L);
                        continue;
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.currentThread().interrupt();
                        continue;
                    }
                    break;
                }
            }
        }).start();
    }

    public static void main(String[] stringArray) {
        new TreeNodeAdder();
    }
}
