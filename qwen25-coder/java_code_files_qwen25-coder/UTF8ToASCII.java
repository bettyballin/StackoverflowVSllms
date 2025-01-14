import com.ibm.icu.text.Transliterator;

public class UTF8ToASCII {
    public static void main(String[] args) {
        // Create a Transliterator instance for Latin-Accents to ASCII
        Transliterator transliterator = Transliterator.getInstance("Latin-Accents");

        // Sample input
        String utf8Text = "Café Münchner Straße Ångström";
        
        // Convert to ASCII
        String asciiText = transliterator.transliterate(utf8Text);
        
        System.out.println("Original: " + utf8Text);
        System.out.println("ASCII: " + asciiText);
    }
}