import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.TerminalSize;
import java.io.IOException;
import java.util.Arrays;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class LanternaExample {
    public static void main(String[] args){
        // Initialise terminal and create a screen object to use (for windowing support)
        Terminal term = null;
        try {
            term = new DefaultTerminalFactory().createTerminal();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Screen screen = null;
        try {
            screen = new TerminalScreen(term);
            screen.startScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a window at the position of your choice with arbitrary dimensions
        Window win = new BasicWindow("Test");
        int xPosOfWin = 20;
        int yPosOfWin = 30;
        int widthOfWin = screen.getTerminalSize().getColumns()/4; // quarter size of terminal
        int heightOfWin = screen.getTerminalSize().getRows() / 5; // fifth height of terminal

        win.setHints(Arrays.asList(Window.Hint.NO_DECORATIONS));

        try {
            WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);
            textGUI.addWindow(win);

            screen.doResizeIfNecessary();
        } catch (Exception e) { }

        // Update window while user is inputting commands elsewhere in terminal:
        final Terminal finalTerm = term;
        new Thread(){ 
            public void run() {
                try{
                    char[] buffer = new char[10]; // create char array to store read data
                    for(int i=0; i<5; i++){
                        KeyStroke keyStroke = finalTerm.readInput(); // Read from terminal
                        if (keyStroke != null && keyStroke.getCharacter() != null) {
                            buffer[i%buffer.length] = keyStroke.getCharacter();  // store character
                        }
                        String str = String.valueOf(buffer).trim();   // convert buffer data into string
                        System.out.println("Entered Data: " +str+ ", length of entered data is :"+ str.length()); // print and validate the entered data
                    }
                }catch (Exception e){}
            }
        }.start();
    }
}