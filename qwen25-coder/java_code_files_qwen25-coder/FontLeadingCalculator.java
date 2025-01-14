import java.lang.String;
public class FontLeadingCalculator {
    public static void main(String[] args) {
        // Example TTF values for a font
        short ascender = 938;   // Example Ascender value from OS/2 table
        short descender = -250; // Example Descender value from OS/2 table
        short lineGap = 0;      // Example LineGap value from OS/2 table

        float fontSize = 12.0f; // Desired font size in points

        // Calculate leading using Ascender, Descender, and LineGap
        float leading = (ascender - descender + lineGap) * (fontSize / 1000.0f);
        
        System.out.println("Calculated Leading: " + leading + " points");

        // If LineGap is zero or not sensible, use alternative calculation
        if (lineGap == 0) {
            float alternativeLeading = ((ascender - descender) * 1.2f) * (fontSize / 1000.0f);
            System.out.println("Alternative Leading: " + alternativeLeading + " points");
        }
    }
}