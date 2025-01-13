import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.GenericParser;

public class Main_59 {
    public static void main(String[] args) throws HL7Exception {
        GenericParser parser = new GenericParser();
        EncodingCharacters encodingChars = new EncodingCharacters('|', '^', '~', '\\', '&');
        String hl7Message = "your_hl7_message"; // Replace with your actual HL7 message
        Message message = parser.parse(hl7Message, encodingChars);
        // ... (rest of your code)
    }
}