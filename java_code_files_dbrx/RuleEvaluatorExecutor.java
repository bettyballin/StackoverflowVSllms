import java.util.List;

public class RuleEvaluatorExecutor {
    public boolean execute(List<RuleEvaluator> ruleList, Object context) {
        for (RuleEvaluator evaluator : ruleList) {
            if (!evaluator.evaluate(context)) {
                return false; // stop checking once a condition isn't met
            }
        }
        return true; // all conditions are met so we can assume everything went well
    }

    public static void main(String[] args) {
    }
}

interface RuleEvaluator {
    boolean evaluate(Object context);
}