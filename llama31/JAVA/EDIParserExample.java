import java.lang.String;
import com.openedi.EDIFile;
import com.openedi.EDIParser;

public class EDIParserExample {
    public static void main(String[] args) {
        // Load the EDI file
        EDIFile ediFile = new EDIFile("example.edi");

        // Create an EDI parser
        EDIParser parser = new EDIParser();

        // Parse the EDI file
        parser.parse(ediFile);

        // Process the parsed EDI data
        // ...
    }
}