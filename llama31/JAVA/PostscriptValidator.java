import org.ghostscript.Ghostscript;
import org.ghostscript.GhostscriptException;

public class PostscriptValidator {
    public static void main(String[] args) {
        Ghostscript gs = new Ghostscript();
        gs.init();
        try {
            gs.runString("input.ps");
            System.out.println("Postscript file is valid");
        } catch (GhostscriptException e) {
            System.out.println("Postscript file is invalid: " + e.getMessage());
        } finally {
            gs.exit();
        }
    }
}