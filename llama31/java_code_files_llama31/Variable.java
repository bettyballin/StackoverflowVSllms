/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;

class Variable
implements Expression {
    private String name;

    public Variable(String string) {
        this.name = string;
    }

    @Override
    public Object eval(Map<String, Object> map) {
        return map.get(this.name);
    }
}
