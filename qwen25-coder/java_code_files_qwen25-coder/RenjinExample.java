import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.renjin.sexp.SEXP;

public class RenjinExample {
    public static void main(String[] args) throws ScriptException {
        // Create a ScriptEngineManager and get the Renjin engine
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("Renjin");

        // Create bindings
        Bindings bindings = engine.createBindings();

        // Define an R expression
        String rExpression = "mean(c(1, 2, 3, 4, 5))";

        // Evaluate the expression
        SEXP result = (SEXP) engine.eval(rExpression, bindings);
        System.out.println("Result: " + result.asReal());
    }
}