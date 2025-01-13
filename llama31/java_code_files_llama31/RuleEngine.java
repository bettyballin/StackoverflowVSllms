/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

class RuleEngine {
    private List<Rule> rules;

    public RuleEngine(List<Rule> list) {
        this.rules = list;
    }

    public void evaluate(Context context) {
        for (Rule rule : this.rules) {
            rule.evaluate(context);
        }
    }
}
