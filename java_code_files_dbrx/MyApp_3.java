import javax.swing.*;

public class MyApp {

    public static void main(String[] args) {
        // Create components
        JComponent myComponent = new JButton("Button");
        JComponent myHeavyComponent = new JPanel();

        // enable / disable components as required, based on state of application
        myComponent.setEnabled(false); // if component isn't currently in use
        myHeavyComponent.setVisible(false); // hide heavy components or layers when they are not needed
    }
}