/*
 * Decompiled with CFR 0.152.
 */
public class QueryCompiler {
    public static void compileQuery(Term[] termArray) {
        Query query = new Query();
        for (Term term : termArray) {
            if (term.getOperator() == Operator.AND) {
                query.addFilter(term.getFactor().getColumn(), term.getFactor().getOperator(), term.getFactor().getValue());
                continue;
            }
            query.addFilter(term.getFactor().getColumn(), term.getFactor().getOperator(), term.getFactor().getValue());
        }
    }

    public static void main(String[] stringArray) {
        Term[] termArray = new Term[]{};
        QueryCompiler.compileQuery(termArray);
    }
}
