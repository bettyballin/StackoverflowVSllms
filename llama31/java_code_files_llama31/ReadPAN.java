/*
 * Decompiled with CFR 0.152.
 */
import javax.smartcardio.Card;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;

public class ReadPAN {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        TerminalFactory terminalFactory = TerminalFactory.getDefault();
        Card card = null;
        try {
            CardTerminal cardTerminal = terminalFactory.terminals().list().get(0);
            card = cardTerminal.connect("*");
            byte[] byArray = new byte[]{0, -92, 4, 0, 7, -96, 0, 0, 0, 4, 16, 16};
            ResponseAPDU responseAPDU = card.getBasicChannel().transmit(new CommandAPDU(byArray));
            if (responseAPDU.getSW1() != -112) {
                System.out.println("Error selecting EMV application");
                return;
            }
            byte[] byArray2 = new byte[]{0, -78, 1, 12, 0};
            responseAPDU = card.getBasicChannel().transmit(new CommandAPDU(byArray2));
            if (responseAPDU.getSW1() != -112) {
                System.out.println("Error reading record");
                return;
            }
            byte[] byArray3 = responseAPDU.getData();
            String string = new String(byArray3).trim();
            System.out.println("PAN: " + string);
        }
        catch (CardException cardException) {
            System.out.println("Error communicating with card");
        }
        finally {
            if (card != null) {
                try {
                    card.disconnect(false);
                }
                catch (CardException cardException) {
                    System.out.println("Error disconnecting from card");
                }
            }
        }
    }
}
