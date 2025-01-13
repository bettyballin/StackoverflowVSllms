import java.awt.BorderLayout;

import javax.swing.Button;
import javax.swing.JPanel;

// Assuming Panel, EditorGridPanel, VBoxLayout, TopPanel are custom classes
// If not, you need to import or define them properly
class Panel extends JPanel {}
class EditorGridPanel extends JPanel {}
class VBoxLayout {}
class TopPanel extends JPanel {}

public class GridPanelContainer {
    public static void main(String[] args) {
        GridPanelContainer container = new GridPanelContainer();
    }

    public GridPanelContainer() {
        CenterPanel centerPanel = new Panel();
        centerPanel.setLayout(new VBoxLayout());

        EditorGridPanel grid = new EditorGridPanel();
        grid.setAutoHeight(true);
        grid.setAutoWidth(true);

        // Add the grid to the center panel
        centerPanel.add(grid);

        // Add the buttons below the grid
        centerPanel.add(new Button("Button 1"));
        centerPanel.add(new Button("Button 2"));
        centerPanel.add(new Button("Button 3"));

        // Add the center panel to the TopPanel
        TopPanel topPanel = new TopPanel();
        topPanel.add(centerPanel, BorderLayout.CENTER);
    }
}