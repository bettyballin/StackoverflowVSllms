import java.lang.String;
import org.apache.commons.lang3.SystemUtils;
import org.jline.reader.*;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
public class Main_317 {
    public static void main(String[] args) throws Exception{
        Terminal terminal = TerminalBuilder.builder().system(true).build();
        LineReader reader = LineReaderBuilder.builder()
            .terminal(terminal) // if you want raw/native input and output
            .build();
        String text;
        while ((text =  reader.readLine(">>")) != null){   // loop until user types Ctrl+C or quit command then Enter
            System.out.println("User entered: " + text);
        }
    }
}