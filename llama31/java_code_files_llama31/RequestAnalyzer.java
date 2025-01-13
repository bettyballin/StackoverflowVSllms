/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class RequestAnalyzer {
    public static void main(String[] stringArray) {
        RequestAnalyzer requestAnalyzer = new RequestAnalyzer();
        requestAnalyzer.analyzeRequest();
    }

    private void analyzeRequest() {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.addHeader("Accept", "application/json");
        String string = mockHttpServletRequest.getHeader("Accept");
        if (string.contains("application/json") || string.contains("application/xml")) {
            System.out.println("Request was likely made via AJAX");
        }
    }

    private static class MockHttpServletRequest {
        private HashMap<String, String> headers = new HashMap();

        private MockHttpServletRequest() {
        }

        public void addHeader(String string, String string2) {
            this.headers.put(string, string2);
        }

        public String getHeader(String string) {
            return this.headers.get(string);
        }
    }
}
