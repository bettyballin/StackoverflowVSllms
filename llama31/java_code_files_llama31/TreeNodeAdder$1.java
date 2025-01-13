/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

class TreeNodeAdder.1
implements Runnable {
    TreeNodeAdder.1() {
    }

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
}
