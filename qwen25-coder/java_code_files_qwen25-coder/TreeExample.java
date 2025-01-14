import java.lang.String;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

public class TreeExample {
    public static void main(String[] args) throws InterruptedException {
        final JFrame frame = new JFrame("Dynamic JTree Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);

        MutableTreeNode root = new DefaultMutableTreeNode("root");
        final DefaultTreeModel model = new DefaultTreeModel(root);
        final JTree tree = new JTree(model);
        frame.add(new JScrollPane(tree));

        Runnable updateRunnable = new Runnable() {
            private int count = 0;

            @Override
            public void run() {
                while (count < 1000) { // Limiting to 1000 nodes for demonstration
                    final MutableTreeNode child = new DefaultMutableTreeNode("test " + count++);
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            model.insertNodeInto(child, root, root.getChildCount());
                            tree.expandRow(tree.getRowCount() - 1);
                        }
                    });

                    try {
                        Thread.sleep(1); // Simulate delay if needed
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(updateRunnable).start();

        frame.setVisible(true);
    }
}