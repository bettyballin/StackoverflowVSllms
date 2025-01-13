/*
 * Decompiled with CFR 0.152.
 */
import java.io.StringWriter;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

public class ScriptExecutor {
    public static void main(String[] stringArray) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("groovy");
        SimpleScriptContext simpleScriptContext = new SimpleScriptContext();
        simpleScriptContext.setWriter(new StringWriter());
        String string = "println 'Hello, World!';";
        try {
            scriptEngine.eval(string, (ScriptContext)simpleScriptContext);
        }
        catch (ScriptException scriptException) {
            System.err.println("Error executing script: " + scriptException.getMessage());
        }
    }
}
