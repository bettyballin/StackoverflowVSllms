import java.util.HashMap;
import java.util.Map;

interface Expression {
    boolean evaluate(Context context);
}

class Context {
    Map<String, Object> data; // Holds data needed for evaluation

    public Context() {
        this.data = new HashMap<>();
    }

    public void setData(Map<String, Object> data) {
        this.data.putAll(data);
    }
}

class AndExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public AndExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean evaluate(Context context) {
        return left.evaluate(context) && right.evaluate(context);
    }
}

class OrExpression implements Expression {
    private final Expression left;
    private final Expression right;

    public OrExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean evaluate(Context context) {
        return left.evaluate(context) || right.evaluate(context);
    }
}

class HasCollarExpression implements Expression {
    private final String object;

    public HasCollarExpression(String object) {
        this.object = object;
    }

    @Override
    public boolean evaluate(Context context) {
        // Assuming data contains the necessary information about objects and their attributes
        return context.data.containsKey(object + "_collar");
    }
}

class InAreaExpression implements Expression {
    private final String object;
    private final String area;

    public InAreaExpression(String object, String area) {
        this.object = object;
        this.area = area;
    }

    @Override
    public boolean evaluate(Context context) {
        // Assuming data contains the necessary information about objects and their locations
        return area.equals(context.data.get(object + "_location"));
    }
}

public class Main_36 {
    public static void main(String[] args) {
        Context context = new Context();
        Map<String, Object> initialData = new HashMap<>();
        initialData.put("dog_collar", true);
        initialData.put("dog_location", "park");
        context.setData(initialData);

        Expression hasCollar = new HasCollarExpression("dog");
        Expression inPark = new InAreaExpression("dog", "park");

        Expression rule = new AndExpression(hasCollar, inPark);

        boolean result = rule.evaluate(context);
        System.out.println(result); // Output: true if the dog has a collar and is in the park
    }
}