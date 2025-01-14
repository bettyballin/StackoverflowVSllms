import java.lang.String;
import java.util.Set;

public class TerminalSizeConfigurator {

    private Device device = new Device();
    private Terminal terminal = new Terminal();

    public void configureTerminalSize() {
        // Get screen dimensions
        int screenWidth = device.getScreenWidth();
        int screenHeight = device.getScreenHeight();

        // Define character size for font (this should be dynamically obtained based on the chosen font)
        int charWidth = 8; // example width
        int charHeight = 16; // example height

        // Calculate number of columns and rows
        int numColumns = screenWidth / charWidth;
        int numRows = screenHeight / charHeight;

        // Set terminal size
        setTerminalSize(numColumns, numRows);
    }

    // Method to set terminal size in the client
    private void setTerminalSize(int columns, int rows) {
        terminal.setColumns(columns);
        terminal.setRows(rows);
    }

    public static void main(String[] args) {
        // Optionally, create an instance and call the method
        TerminalSizeConfigurator configurator = new TerminalSizeConfigurator();
        configurator.configureTerminalSize();
    }
}

class Device {
    public int getScreenWidth() {
        return 800; // Example value
    }

    public int getScreenHeight() {
        return 600; // Example value
    }
}

class Terminal {
    public void setColumns(int columns) {
        // Placeholder implementation
        System.out.println("Setting terminal columns to " + columns);
    }

    public void setRows(int rows) {
        // Placeholder implementation
        System.out.println("Setting terminal rows to " + rows);
    }
}