public class representing_1 {
    // Immutable class representing a safe string
    final class SafeString {
        private final String value;

        public SafeString(String value) {
            if (value == null) throw new IllegalArgumentException("Value cannot be null");
            // Assume the string is already sanitized or validated here
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    // Class representing an unsafe string, requiring explicit sanitization
    final class UnsafeString {
        private final String value;

        public UnsafeString(String value) {
            if (value == null) throw new IllegalArgumentException("Value cannot be null");
            this.value = value;
        }

        // Method to convert UnsafeString to SafeString
        public SafeString sanitize() {
            // Perform sanitization logic here
            return new SafeString(this.value.replaceAll("[^a-zA-Z0-9]", ""));
        }
    }

    public static void main(String[] args) {
    }
}