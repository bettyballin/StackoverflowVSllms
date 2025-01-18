import java.awt.Color;

public class CustomColorWatcher {
    // Assuming colorDialog is an instance of a class that provides getCustomColor()
    static ColorDialog colorDialog = new ColorDialog();

    // Initialize a variable to store initial custom color value
    static Color initialCustomColor = colorDialog.getCustomColor();

    public static void main(String[] args) {
        try {
            while (true) {
                // Fetch current custom color value
                Color currentCustomColor = colorDialog.getCustomColor();

                if (!initialCustomColor.equals(currentCustomColor)) {
                    System.out.println("User has changed the custom colors");
                    initialCustomColor = currentCustomColor;
                } else {
                    Thread.sleep(100);  // Sleep for a short duration to prevent infinite loop and high CPU usage
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ColorDialog {
    public Color getCustomColor() {
        // Return a color; for the purpose of compiling, we can return a default color
        return Color.BLACK;
    }
}