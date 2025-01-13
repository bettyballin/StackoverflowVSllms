import java.lang.String;

public class ImagePropertiesCalculator {
    int bpp = calculateBitsPerPixel(8, 3); // bpp = 24

    public static void main(String[] args) {
    }

    public static int calculateBitsPerPixel(int bitsPerComponent, int numberOfComponents) {
        return bitsPerComponent * numberOfComponents;
    }
}