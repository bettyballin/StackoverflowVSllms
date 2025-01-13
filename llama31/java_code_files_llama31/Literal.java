/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;

class Literal
implements Expression {
    private Object value;

    public Literal(Object object) {
        this.value = object;
    }

    @Override
    public Object eval(Map<String, Object> map) {
        return this.value;
    }
}
