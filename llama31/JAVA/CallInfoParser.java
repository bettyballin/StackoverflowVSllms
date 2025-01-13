import java.lang.String;
public class CallInfoParser {
    public static void parseCallInfo(char[] callInfo) {
        // First character
        byte b = (byte) callInfo[0];

        // Check the bits
        boolean incomingCall = (b & 0x80) != 0; // Bit 7
        boolean outgoingCall = (b & 0x40) != 0; // Bit 6
        boolean internalCall = (b & 0x20) != 0; // Bit 5
        boolean cnCall = (b & 0x10) != 0; // Bit 4

        // Do something with the parsed values...
    }

	public static void main(String[] args) {
	}
}