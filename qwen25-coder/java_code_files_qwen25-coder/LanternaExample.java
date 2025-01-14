import java.lang.String;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class LanternaExample {
    public static void main(String[] args) throws Exception {
        // Create a default terminal factory
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();

        // Create the terminal
        Terminal terminal = defaultTerminalFactory.createTerminal();

        // Create and start the screen
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        try {
            // Create TextGraphics for drawing
            TextGraphics tg = screen.newTextGraphics();

            // Set background color and clear the screen
            screen.setCursorPosition(null);
            tg.setBackgroundColor(TextColor.ANSI.BLUE);
            tg.fill(' ');

            // Define a window region
            TerminalSize screenSize = screen.getTerminalSize();
            int columns = 40;
            int rows = 10;
            int startX = (screenSize.getColumns() - columns) / 2;
            int startY = (screenSize.getRows() - rows) / 2;

            // Draw a rectangle
            tg.drawRectangle(
                new TerminalPosition(startX, startY),
                new TerminalSize(columns + 1, rows + 1),
                ' ');

            KeyStroke key;
            while ((key = screen.pollInput()) == null) {
                // Update content in the rectangular window (simulation of regular updates)
                String text = "Hello, Lanterna!";
                int textLength = text.length();
                int textStartX = startX + (columns - textLength) / 2;

                tg.setForegroundColor(TextColor.ANSI.WHITE);
                tg.setBackgroundColor(TextColor.ANSI.BLUE);
                tg.putString(textStartX, startY + rows / 2, text);

                // Refresh the screen
                screen.refresh(Screen.RefreshType.COMPLETE);
            }
        } finally {
            // Stop the screen to clean up resources
            screen.stopScreen();
        }
    }
}