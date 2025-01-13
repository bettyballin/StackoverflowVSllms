import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import java.util.HashMap;
import java.util.Map;

public class Main_228 {
    public static void main(String[] args) {
        // Create a JEXL engine
        JexlEngine engine = new JexlBuilder().create();

        // Parse the user-generated condition
        String condition = "{\"and\":[{\"variable\":\"var1\",\"value\":true},{\"variable\":\"var2\",\"value\":false}]}";
        JexlExpression expr = engine.createExpression(condition);

        // Evaluate the condition
        Map<String, Object> context = new HashMap<>();
        context.put("var1", true);
        context.put("var2", false);
        boolean result = (Boolean) expr.evaluate(context);

        // Take action if the condition is true
        if (result) {
            // Fire off the action
            System.out.println("Condition is true, firing off the action...");
        } else {
            System.out.println("Condition is false, no action taken.");
        }
    }
}