/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

class HttpSession {
    private Map<String, Object> attributes = new HashMap<String, Object>();

    HttpSession() {
    }

    public void setAttribute(String string, Object object) {
        this.attributes.put(string, object);
    }

    public Object getAttribute(String string) {
        return this.attributes.get(string);
    }
}
