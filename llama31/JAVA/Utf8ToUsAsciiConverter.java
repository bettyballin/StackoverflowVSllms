public class Utf8ToUsAsciiConverter {
    public static String convert(String utf8String) {
        // Basic implementation to replace some characters for demonstration
        return utf8String
                .replace("Å", "A")
                .replace("ä", "a")
                .replace("ö", "o")
                .replace("ü", "u");
    }

    public static void main(String[] args) {
        String utf8String = "Åäöü";
        String usAsciiString = convert(utf8String);
        System.out.println(usAsciiString); // prints "Aaou"
    }
}