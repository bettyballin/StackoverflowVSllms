import java.util.HashMap;
import java.util.Map;

interface Expression {
    Object eval(Map<String, Object> env);
}

class Literal implements Expression {
    private Object value;

    public Literal(Object value) {
        this.value = value;
    }

    @Override
    public Object eval(Map<String, Object> env) {
        return value;
    }
}

class Variable implements Expression {
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public Object eval(Map<String, Object> env) {
        return env.get(name);
    }
}

class Evaluator {
    public Object eval(Expression exp, Map<String, Object> env) {
        return exp.eval(env);
    }
}

public class Main_830 {
    public static void main(String[] args) {
        Evaluator evaluator = new Evaluator();
        Map<String, Object> env = new HashMap<>();
        env.put("x", 10);

        Literal literal = new Literal(5);
        Variable variable = new Variable("x");

        System.out.println(evaluator.eval(literal, env)); // prints 5
        System.out.println(evaluator.eval(variable, env)); // prints 10
    }
}