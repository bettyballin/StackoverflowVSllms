import java.lang.String;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class DebugConsole {
    private ScriptEngine engine;

    public DebugConsole() {
        ScriptEngineManager manager = new ScriptEngineManager();
        engine = manager.getEngineByName("js"); // or "groovy" or "jython" if you prefer
    }

    public void evaluate(String code) {
        try {
            engine.eval(code);
        } catch (ScriptException e) {
            // handle exception
        }
    }

	public static void main(String[] args) {
	}
}