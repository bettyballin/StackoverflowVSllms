import java.lang.String;
// Abstract Expression
interface Expression {
    int interpret(Context context);
}

// Terminal Expression
class NumberExpression implements Expression {
    private final int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Context context) {
        return number;
    }
}

// Non-Terminal Expression for Addition
class AddExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }
}

// Context
class Context {
    // No specific data needed for this example, but can be used to store variable values in more complex scenarios.
}

// Example usage
public class InterpreterPatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        Expression expression = new AddExpression(new NumberExpression(10), new NumberExpression(5));
        int result = expression.interpret(context);

        System.out.println("Result: " + result); // Output will be 15
    }
}