import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptContext;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;
import java.io.StringWriter;

public class ScriptExecutor {
    public static void main(String[] args) {
        // Create a script engine manager
        ScriptEngineManager manager = new ScriptEngineManager();

        // Create a script engine for Groovy
        ScriptEngine engine = manager.getEngineByName("groovy");

        // Create a sandboxed execution context
        ScriptContext context = new SimpleScriptContext();
        context.setWriter(new StringWriter()); // Redirect output to a string writer

        String script = "println 'Hello, World!';"; // Define a sample script

        // Execute the script in the sandboxed context
        try {
            engine.eval(script, context);
        } catch (ScriptException e) {
            // Handle script execution errors
            System.err.println("Error executing script: " + e.getMessage());
        }
    }
}