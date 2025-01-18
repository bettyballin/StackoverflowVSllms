import javax.swing.*;
import javax.swing.tree.*;

public class MyProgram {
    public static void main(String[] args) {
        final JFrame frame = new JFrame();

        // Create the root node
        final DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        // Create the tree model and set the root node
        final DefaultTreeModel model = new DefaultTreeModel(root);

        // Create the tree and set the model
        final JTree tree = new JTree(model);

        // Add the tree to a scroll pane and add it to the frame
        frame.add(new JScrollPane(tree));
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true) {
            SwingUtilities.invokeLater(() -> {
                final MutableTreeNode child = new DefaultMutableTreeNode("test");
                model.insertNodeInto(child, root, root.getChildCount());
                int rowIndex = tree.getRowCount() - 1;
                tree.expandRow(rowIndex);
            });
            // Add a small delay to prevent overwhelming the event dispatch thread
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}