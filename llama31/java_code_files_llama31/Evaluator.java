/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;

class Evaluator {
    Evaluator() {
    }

    public Object eval(Expression expression, Map<String, Object> map) {
        return expression.eval(map);
    }
}
