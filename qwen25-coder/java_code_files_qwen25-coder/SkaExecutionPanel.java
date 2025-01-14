import java.lang.String;
import java.lang.Set;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SkaExecutionPanel extends JPanel {

    // ... (existing fields)

    private final JToolBar toolbar = new JToolBar();
    private final JTextArea textOutputArea = new JTextArea(5, 30);
    public static boolean run = false;
    public static boolean pause = true;
    public static boolean step = false;
    public static boolean reset = false;

    private JComboBox<String> speedControl;

    public SkaExecutionPanel(JFrame frame) {
        initSpeedMenu();
        addActionsToToolbar();
        setupOutputArea();

        // Add toolbar to the north part of the main content pane
        frame.getContentPane().add("North", toolbar);

        // Set layout, sizes, etc.
        frame.pack();
    }

    private void initSpeedMenu() {
        speedControl = new JComboBox<>(new String[] {"Slow", "Medium", "Fast"});
        speedControl.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                // Handle item changed event
            }
        });
    }

    private void addActionsToToolbar() {
        toolbar.add(new RunAction());
        toolbar.add(new StepAction());
        toolbar.add(new ResetAction());
        toolbar.add(new PauseAction());
        toolbar.addSeparator();
        toolbar.add(speedControl);
    }

    private void setupOutputArea() {
        Font f = new Font("SansSerif", Font.BOLD, 14);
        textOutputArea.setFont(f);
        add(new JScrollPane(textOutputArea), "South");
    }
    
    // ... (existing methods)

    private class RunAction extends AbstractAction {
        public RunAction() {
            putValue(NAME, "Run");
        }

        public void actionPerformed(ActionEvent e) {
            // Handle run action
        }
    }

    private class StepAction extends AbstractAction {
        public StepAction() {
            putValue(NAME, "Step");
        }

        public void actionPerformed(ActionEvent e) {
            // Handle step action
        }
    }

    private class ResetAction extends AbstractAction {
        public ResetAction() {
            putValue(NAME, "Reset");
        }

        public void actionPerformed(ActionEvent e) {
            // Handle reset action
        }
    }

    private class PauseAction extends AbstractAction {
        public PauseAction() {
            putValue(NAME, "Pause");
        }

        public void actionPerformed(ActionEvent e) {
            // Handle pause action
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ska Execution Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SkaExecutionPanel panel = new SkaExecutionPanel(frame);
        frame.getContentPane().add(panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}