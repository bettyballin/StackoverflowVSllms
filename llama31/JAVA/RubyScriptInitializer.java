import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class RubyScriptInitializer {
    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngineFactory factory = manager.getEngineFactoryByName("jruby");
        ScriptEngine engine = factory.getScriptEngine();
    }
}