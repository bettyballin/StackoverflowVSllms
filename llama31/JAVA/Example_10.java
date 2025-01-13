import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class Example_10_10 {
    public static void main(String[] args) throws FindFailed {
        Screen screen = new Screen();
        Match match = screen.find("image/button.png");
        match.click();
    }
}