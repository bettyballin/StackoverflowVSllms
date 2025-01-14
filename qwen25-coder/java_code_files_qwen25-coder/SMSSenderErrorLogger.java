public class SMSSenderErrorLogger {
    public void sendSms(String recipient, String message) {
        try {
            // Assuming submitSMS is a method to send an SMS and returns a status code
            int statusCode = submitSMS(recipient, message);
            if (statusCode != 0) { // 0 typically means success
                handleStatusCode(statusCode);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while sending the SMS: " + e.getMessage());
        }
    }

    public void handleStatusCode(int statusCode) {
        switch (statusCode) {
            case 0x14:
                System.err.println("SMS submission failed due to ESME_RSUBMITFAIL.");
                break;
            default:
                System.err.println("SMS submission failed with status code: " + Integer.toHexString(statusCode));
        }
    }

    private int submitSMS(String recipient, String message) throws Exception {
        // Simulate SMS submission and return status code
        return 0; // Return 0 to indicate success
    }

    public static void main(String[] args) {
        // Empty main method
    }
}