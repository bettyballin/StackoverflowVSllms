/*
 * Decompiled with CFR 0.152.
 */
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main_29 {
    public static void main(String[] stringArray) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("js");
        try {
            scriptEngine.eval("console.log('Hello, World!');");
        }
        catch (ScriptException scriptException) {
            System.out.println(scriptException.getMessage());
        }
    }
}
