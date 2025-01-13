/*
 * Decompiled with CFR 0.152.
 */
public class ReteExample {
    public static void main(String[] stringArray) {
        Rule rule = new Rule("example", "x > 5", "x is greater than 5");
        Rete rete = new Rete();
        rete.addRule(rule);
        Fact fact = new Fact("x", 7);
        rete.assertFact(fact);
        rete.run();
    }
}
