import java.lang.String;
import javax.smartcardio.*;
import java.util.List;

public class SmartCardReader {
    public static void main(String[] args) {
        try {
            // Establish connection to the terminal (reader)
            TerminalFactory factory = TerminalFactory.getDefault();
            List<CardTerminal> terminals = factory.terminals().list();

            if (!terminals.isEmpty()) {
                CardTerminal terminal = terminals.get(0);
                if (terminal.isCardPresent()) {
                    Card card = terminal.connect("T=1");
                    CardChannel channel = card.getBasicChannel();

                    // Example APDU command to select the EMV application on the card
                    byte[] SELECT_COMMAND = { (byte) 0x00, (byte) 0xA4, (byte) 0x04, (byte) 0x00, (byte) 0x1A };
                    byte[] AID_MAESTRO = {
                        (byte) 0xD2, (byte) 0x76, (byte) 0x00, (byte) 0x00, (byte) 0x38, 
                        (byte) 0xAE, (byte) 0xC8, (byte) 0x00, (byte) 0x00, (byte) 0x01, 
                        (byte) 0xB4, (byte) 0xA6, (byte) 0xC9, (byte) 0x1A, (byte) 0x37,
                        (byte) 0xC8, (byte) 0x42, (byte) 0xAD, (byte) 0x5B, (byte) 0xB5
                    };

                    CommandAPDU selectApp = new CommandAPDU(SELECT_COMMAND[0], SELECT_COMMAND[1], 
                            SELECT_COMMAND[2], SELECT_COMMAND[3], AID_MAESTRO);
                    ResponseAPDU response = channel.transmit(selectApp);

                    if ((response.getSW() & 0xFFFF) == 0x9000) {

                        // Example APDU command to get data (modify with correct tag)
                        byte[] GET_DATA_COMMAND = { (byte) 0x80, (byte) 0xCA, (byte) 0x3F, (byte) 0xFF };
                        CommandAPDU getDataCommand = new CommandAPDU(GET_DATA_COMMAND);
                        response = channel.transmit(getDataCommand);

                        if ((response.getSW() & 0xFFFF) == 0x9000) {
                            byte[] responseData = response.getData();
                            System.out.println("Response Data: " + bytesToHex(responseData));
                        } else {
                            System.err.println("Failed to get data, status word is not 0x9000");
                        }
                    } else {
                        System.err.println("Failed to select application, status word is not 0x9000");
                    }

                    card.disconnect(false);
                } else {
                    System.out.println("No card present in the terminal.");
                }
            } else {
                System.out.println("No smartcard readers found.");
            }
        } catch (CardException e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] bytes) {
        final char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}