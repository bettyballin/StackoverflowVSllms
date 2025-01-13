/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

private static class RequestAnalyzer.MockHttpServletRequest {
    private HashMap<String, String> headers = new HashMap();

    private RequestAnalyzer.MockHttpServletRequest() {
    }

    public void addHeader(String string, String string2) {
        this.headers.put(string, string2);
    }

    public String getHeader(String string) {
        return this.headers.get(string);
    }
}
