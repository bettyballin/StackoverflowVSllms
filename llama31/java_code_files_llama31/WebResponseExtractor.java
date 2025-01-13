/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;

public class WebResponseExtractor {
    private byte[] responseBytes;
    private Map<String, String> headers;

    public WebResponseExtractor(WrappedResponse wrappedResponse) {
        this.responseBytes = wrappedResponse.getResponseBytes();
        this.headers = wrappedResponse.getHeaders();
    }

    public static void main(String[] stringArray) {
    }
}
