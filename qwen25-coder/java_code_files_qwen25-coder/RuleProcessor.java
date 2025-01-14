import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import java.util.Map;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

class Rule {
    String condition;
    String action;
}

public class RuleProcessor {
    private List<Rule> rules;

    public RuleProcessor(String ruleFilePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        this.rules = mapper.readValue(new File(ruleFilePath),
            mapper.getTypeFactory().constructCollectionType(List.class, Rule.class));
    }

    public void process(UserInput userInput) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        try {
            for (Rule rule : rules) {
                // Set up variables
                engine.put("keyword1_count", userInput.keywordCounts.getOrDefault("keyword1", 0));
                String keyword5 = (userInput.keywords.size() > 4) ? userInput.keywords.get(4) : "";
                engine.put("keyword5", keyword5); // Assuming 0-indexed

                if ((Boolean) engine.eval(rule.condition)) {
                    executeAction(rule.action);
                }
            }
        } catch (ScriptException e) {
            System.err.println("Error evaluating rule: " + e.getMessage());
        }
    }

    private void executeAction(String action) {
        // Based on the action string, execute the corresponding method
        if ("alert_user()".equals(action)) {
            alertUser();
        }
        // Add more actions as necessary
    }

    private void alertUser() {
        System.out.println("Alert: Condition met!");
    }
}

class UserInput {
    List<String> keywords;
    Map<String, Integer> keywordCounts;

    public static void main(String[] args) {
    }
}