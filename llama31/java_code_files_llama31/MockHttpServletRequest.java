/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

class MockHttpServletRequest {
    private Map<String, Object> attributes = new HashMap<String, Object>();

    MockHttpServletRequest() {
    }

    public void setAttribute(String string, Object object) {
        this.attributes.put(string, object);
    }
}
