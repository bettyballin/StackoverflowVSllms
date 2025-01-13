/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class GrammarRules {
    public Expression EXPR(List<Term> list) {
        Expression expression = new Expression();
        for (Term term : list) {
            expression.addTerm(term);
        }
        return expression;
    }

    public Term TERM(Factor factor, String string) {
        return new Term(factor, string);
    }

    public Factor FACTOR(String string, String string2) {
        if (string != null) {
            return new IndexQueryFactor(string);
        }
        return new FilterFactor(string2);
    }

    public static void main(String[] stringArray) {
        GrammarRules grammarRules = new GrammarRules();
        Factor factor = grammarRules.FACTOR("indexQuery", null);
        Term term = grammarRules.TERM(factor, "operator");
        ArrayList<Term> arrayList = new ArrayList<Term>();
        arrayList.add(term);
        Expression expression = grammarRules.EXPR(arrayList);
    }
}
