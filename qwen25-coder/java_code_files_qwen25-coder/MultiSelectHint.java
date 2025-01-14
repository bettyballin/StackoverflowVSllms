import java.lang.String;
import javax.swing.*;
import java.awt.*;

public class MultiSelectHint {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Multi-Select Hint Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            JList<String> list = new JList<>(new String[]{"Item 1", "Item 2", "Item 3"});
            frame.add(list, BorderLayout.CENTER);

            // Use Unicode for the Command symbol
            char commandSymbol = '\u2318';
            JLabel hintLabel;
            if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                hintLabel = new JLabel(String.format("With %c you can select multiple items", commandSymbol));
            } else {
                hintLabel = new JLabel("With CTRL you can select multiple items");
            }
            frame.add(hintLabel, BorderLayout.SOUTH);

            frame.pack();
            frame.setVisible(true);
        });
    }
}