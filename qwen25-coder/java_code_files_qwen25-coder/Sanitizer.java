import org.owasp.encoder.Encode;

public class Sanitizer {

    public String sanitizeEmbedCode(String embedCode) {
        // HTML escape to prevent XSS
        return Encode.forHtml(embedCode);
    }
}

// Minimal implementation of org.owasp.encoder.Encode
package org.owasp.encoder;

public class Encode {
    public static String forHtml(String input) {
        // Implementation of HTML encoding to prevent XSS
        // This is a simplified version for demonstration purposes

        if (input == null) {
            return null;
        }
        return input.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#x27;")
                    .replace("/", "&#x2F;");
    }
}