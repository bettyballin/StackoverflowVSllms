/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

class TreeNodeAdderWorker.1
extends SwingWorker<Void, MutableTreeNode> {
    TreeNodeAdderWorker.1() {
    }

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
}
