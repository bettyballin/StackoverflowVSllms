public class StatusType {
    public enum Status {
        VALID("valid"), OLD("old");

        private final String val;

        Status(String val) {
            this.val = val;
        }

        public String getStatus() {
            return val;
        }

        // Static accessors
        public static final String VALID_STATUS = VALID.getStatus();
        public static final String OLD_STATUS = OLD.getStatus();
    }
    public static void main(String[] args) {
    }
}