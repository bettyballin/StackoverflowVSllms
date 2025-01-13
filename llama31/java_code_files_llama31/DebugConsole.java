/*
 * Decompiled with CFR 0.152.
 */
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class DebugConsole {
    private ScriptEngine engine;

    public DebugConsole() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        this.engine = scriptEngineManager.getEngineByName("js");
    }

    public void evaluate(String string) {
        try {
            this.engine.eval(string);
        }
        catch (ScriptException scriptException) {
            // empty catch block
        }
    }

    public static void main(String[] stringArray) {
    }
}
