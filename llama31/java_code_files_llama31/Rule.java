/*
 * Decompiled with CFR 0.152.
 */
class Rule {
    private String name;
    private String antecedent;
    private String consequent;

    public Rule(String string, String string2, String string3) {
        this.name = string;
        this.antecedent = string2;
        this.consequent = string3;
    }

    public String getAntecedent() {
        return this.antecedent;
    }

    public String getConsequent() {
        return this.consequent;
    }
}
