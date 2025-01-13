/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.tree.MutableTreeNode;

class TreeNodeAdder.1
implements Runnable {
    final /* synthetic */ MutableTreeNode val$child;

    TreeNodeAdder.1() {
        this.val$child = mutableTreeNode;
    }

    @Override
    public void run() {
        this$0.model.insertNodeInto(this.val$child, this$0.root, this$0.root.getChildCount());
        this$0.tree.expandRow(this$0.tree.getRowCount() - 1);
    }
}
