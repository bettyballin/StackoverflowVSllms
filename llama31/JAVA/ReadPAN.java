import javax.smartcardio.*;

public class ReadPAN {
    public static void main(String[] args) {
        // Assume you have a Card object (card) and a TerminalFactory (factory)
        TerminalFactory factory = TerminalFactory.getDefault();
        Card card = null;

        try {
            // Get the first available terminal
            CardTerminal terminal = factory.terminals().list().get(0);
            // Connect to the card
            card = terminal.connect("*");

            // Select the EMV application
            byte[] selectAppletAPDU = {
                (byte) 0x00, (byte) 0xA4, (byte) 0x04, (byte) 0x00, (byte) 0x07,
                (byte) 0xA0, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x04,
                (byte) 0x10, (byte) 0x10
            };
            ResponseAPDU response = card.getBasicChannel().transmit(new CommandAPDU(selectAppletAPDU));
            if (response.getSW1() != (byte) 0x90) {
                System.out.println("Error selecting EMV application");
                return;
            }

            // Send READ RECORD command to retrieve PAN
            byte[] readRecordAPDU = {
                (byte) 0x00, (byte) 0xB2, (byte) 0x01, (byte) 0x0C, (byte) 0x00
            };
            response = card.getBasicChannel().transmit(new CommandAPDU(readRecordAPDU));
            if (response.getSW1() != (byte) 0x90) {
                System.out.println("Error reading record");
                return;
            }

            // Extract PAN from response data
            byte[] pan = response.getData();
            String panStr = new String(pan).trim();
            System.out.println("PAN: " + panStr);

        } catch (CardException e) {
            System.out.println("Error communicating with card");
        } finally {
            if (card != null) {
                try {
                    card.disconnect(false);
                } catch (CardException e) {
                    System.out.println("Error disconnecting from card");
                }
            }
        }
    }
}