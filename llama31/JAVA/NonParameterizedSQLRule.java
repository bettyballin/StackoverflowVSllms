import java.lang.String;
import net.sourceforge.pmd.lang.java.ast.ASTClassOrInterfaceDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTLiteral;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTPrimaryExpression;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;
import net.sourceforge.pmd.lang.java.rule.RuleContext;

public class NonParameterizedSQLRule extends AbstractJavaRule {
    @Override
    public void visit(ASTMethodDeclaration node, Object data) {
        if (node.getName().equals("PreparedStatement")) {
            node.findDescendantsOfType(ASTPrimaryExpression.class).forEach(expr -> {
                if (expr.getLiteral() instanceof ASTLiteral) {
                    String sql = ((ASTLiteral) expr.getLiteral()).getImage();
                    try {
                        new SQLValidator(new Validator()).validateSQL(sql);
                    } catch (ValidationException e) {
                        addViolation((RuleContext) data, expr);
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
    }
}

// The following classes were missing from the original code
class SQLValidator {
    private Validator validator;

    public SQLValidator(Validator validator) {
        this.validator = validator;
    }

    public void validateSQL(String sql) throws ValidationException {
        // SQL validation logic goes here
    }
}

class Validator {
    // Validator logic goes here
}

class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}