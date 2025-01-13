import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ListDemo extends JPanel implements ListSelectionListener {
    private JList list;
    private DefaultListModel listModel;
    private static final String hires[] = {
        "Java", "HotJava", "JustJava", "SuperJava", "NotYourAverageJava", "Jumping Java Beans", "Mocha", "Java Latté", "Java Chai", "Hibiscus"
    };

    public ListDemo() {
        super(new BorderLayout());

        listModel = new DefaultListModel();
        for (String hire : hires) {
            listModel.addElement(hire);
        }
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(1);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(4);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        listScroller.setAlignmentX(LEFT_ALIGNMENT);

        add(listScroller, BorderLayout.CENTER);
    }

    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (list.getSelectedIndex() == -1) {
            //No selection, disable fire button.
            } else {
            //Selection, enable the fire button.
            }
        }
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ListDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new ListDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}