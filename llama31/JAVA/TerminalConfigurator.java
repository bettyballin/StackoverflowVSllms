// Define the Terminal class
class Terminal {
    int columns;
    int rows;

    public Terminal(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
    }
}

public class TerminalConfigurator {
    int defaultColumns = 60;
    int defaultRows = 12;

    // Set terminal size
    Terminal terminal = new Terminal(defaultColumns, defaultRows);

    public static void main(String[] args) {
        TerminalConfigurator configurator = new TerminalConfigurator();
        System.out.println("Terminal size: " + configurator.terminal.columns + "x" + configurator.terminal.rows);
    }
}