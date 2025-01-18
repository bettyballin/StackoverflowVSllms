public class SMSExample {

    // Simulated GPRSModem class instance
    private GPRSModem gprsModem = new GPRSModem();

    public void send_sms(String message, String recipient) {
        // Connect to SMSC or Network provider's SMSC gateway
        gprsModem.sendATCommand("AT+CSOCKSETPN=1");
        gprsModem.sendATCommand("AT+CIPSTART=\"TCP\"", "SMSC IP address", "SMSC Port");
        // Define data content type like 08 or 00 etc., for text SMS, refer to your SMSC documentation
        String smsPDU = "01" + calculate_length(message) + calculate_length(recipient) + recipient + message;
        int lengthOfPDU = smsPDU.length(); // Calculate the length of the PDU
        gprsModem.sendATCommand("AT+CSOSEND=" + lengthOfPDU); // Sending in PDU mode via a socket connection
    }

    private String calculate_length(String s) {
        // Implement length calculation as per PDU requirements
        // For simplicity, return length in hex format
        int len = s.length();
        return Integer.toHexString(len);
    }

    public static void main(String[] args) {
        // Example usage
        SMSExample example = new SMSExample();
        example.send_sms("Hello World", "1234567890");
    }
}

class GPRSModem {
    public void sendATCommand(String command) {
        // Simulate sending an AT command
        System.out.println("Sending AT command: " + command);
    }

    public void sendATCommand(String command, String arg1, String arg2) {
        // Simulate sending an AT command with arguments
        System.out.println("Sending AT command: " + command + ", " + arg1 + ", " + arg2);
    }
}