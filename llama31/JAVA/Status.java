public class StatusClass {
    public enum Status {
        SUCCESS(0),
        FAILURE(1);

        private final int code;

        Status(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    private boolean success;

    public Status run() {
        if (!success) {
            return Status.FAILURE;
        }
        return Status.SUCCESS;
    }

    public static void main(String[] args) {
        StatusClass statusClass = new StatusClass();
        statusClass.success = true; // or false
        Status status = statusClass.run();
        System.out.println(status);
        System.out.println(status.getCode());
    }
}