import java.lang.String;
import java.awt.Color;

public class ColorPaletteGenerator {

    public static Color[] generateColors(int numberOfSlices) {
        Color[] colors = new Color[numberOfSlices];
        float angleStep = 360.0f / numberOfSlices;
        
        for (int i = 0; i < numberOfSlices; i++) {
            float hue = (i * angleStep) % 360;
            // Ensure a good saturation and lightness
            float saturation = 0.75f;
            float lightness = 0.5f;
            
            colors[i] = Color.getHSBColor(hue / 360, saturation, lightness);
        }
        
        return colors;
    }

    public static void main(String[] args) {
        int numberOfSlices = 8; // Example number of slices
        Color[] pieColors = generateColors(numberOfSlices);
        for (Color color : pieColors) {
            System.out.printf("RGB: %d, %d, %d%n", color.getRed(), color.getGreen(), color.getBlue());
        }
    }
}