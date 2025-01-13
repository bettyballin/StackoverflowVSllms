import java.nio.charset.StandardCharsets;

public class Converter_2 {
    public static String convertToEBCDIC(String asciiText) {
        // Assuming you want to use the Cp037 EBCDIC charset, which is one of the most common ones
        return new String(asciiText.getBytes(), StandardCharsets.ISO_8859_1);
    }

    public static String convertToAscii(String ebcdicText) {
        // Assuming you want to use the Cp037 EBCDIC charset, which is one of the most common ones
        return new String(ebcdicText.getBytes(StandardCharsets.ISO_8859_1));
    }

    public static void main(String[] args) {
        Converter_2 converter = new Converter_2();
        System.out.println(converter.ebcdicText);
        System.out.println(converter.asciiTextFromEBCDIC);
    }
}

class Converter_2 {
    String asciiText = "Hello World!";
    String ebcdicText = Converter.convertToEBCDIC(asciiText);

    String ebcdicTextFromAS400 = "..."; // receive from AS400
    String asciiTextFromEBCDIC = Converter.convertToAscii(ebcdicTextFromAS400);
}