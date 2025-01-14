import org.rosuda.JRI.Rengine;
import org.rosuda.JRI.REXP;

public class JRIExample {
    public static void main(String[] args) {
        // Start R engine
        Rengine re = new Rengine(new String[]{"--vanilla"}, false, null);
        if (!re.waitForR()) {
            System.out.println("Cannot load R");
            return;
        }
        
        // Execute R command
        REXP result = re.eval("mean(c(1, 2, 3, 4, 5))");
        if (result == null) {
            System.out.println("Script execution failed.");
        } else {
            System.out.println("Result: " + result.asDouble());
        }
        
        // Stop R engine
        re.end();
    }
}