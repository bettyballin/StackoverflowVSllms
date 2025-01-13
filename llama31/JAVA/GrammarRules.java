import java.util.ArrayList;
import java.util.List;

// Define the classes for Expression, Term, Factor, IndexQueryFactor, and FilterFactor
class Expression {
    private List<Term> terms = new ArrayList<>();

    public void addTerm(Term term) {
        terms.add(term);
    }
}

class Term {
    private Factor factor;
    private String operator;

    public Term(Factor factor, String operator) {
        this.factor = factor;
        this.operator = operator;
    }
}

class Factor {}

class IndexQueryFactor extends Factor {
    private String indexQuery;

    public IndexQueryFactor(String indexQuery) {
        this.indexQuery = indexQuery;
    }
}

class FilterFactor extends Factor {
    private String filter;

    public FilterFactor(String filter) {
        this.filter = filter;
    }
}

public class GrammarRules {
    // Define the actions for each grammar rule
    public Expression EXPR(List<Term> terms) {
        // Combine the terms using AND and OR operators
        Expression expr = new Expression();
        for (Term term : terms) {
            expr.addTerm(term);
        }
        return expr;
    }

    public Term TERM(Factor factor, String operator) {
        // Create a term from the factor and operator
        return new Term(factor, operator);
    }

    public Factor FACTOR(String indexQuery, String filter) {
        // Create a factor from the index query or filter
        if (indexQuery != null) {
            return new IndexQueryFactor(indexQuery);
        } else {
            return new FilterFactor(filter);
        }
    }

    public static void main(String[] args) {
        GrammarRules grammarRules = new GrammarRules();
        // Example usage:
        Factor factor = grammarRules.FACTOR("indexQuery", null);
        Term term = grammarRules.TERM(factor, "operator");
        List<Term> terms = new ArrayList<>();
        terms.add(term);
        Expression expr = grammarRules.EXPR(terms);
    }
}