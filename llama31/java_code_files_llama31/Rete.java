/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

class Rete {
    private List<Rule> rules = new ArrayList<Rule>();
    private List<Fact> facts = new ArrayList<Fact>();

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public void assertFact(Fact fact) {
        this.facts.add(fact);
    }

    public void run() {
        for (Rule rule : this.rules) {
            if (!this.evaluateAntecedent(rule.getAntecedent(), this.facts)) continue;
            this.executeConsequent(rule.getConsequent());
        }
    }

    private boolean evaluateAntecedent(String string, List<Fact> list) {
        return string.equals("x > 5") && list.stream().anyMatch(fact -> fact.getName().equals("x") && (Integer)fact.getValue() > 5);
    }

    private void executeConsequent(String string) {
        System.out.println(string);
    }
}
