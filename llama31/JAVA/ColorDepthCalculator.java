import java.lang.String;

public class ColorDepthCalculator {
    public int calculateBitsPerPixel(int bitsPerComponent, int numColorComponents) {
        return bitsPerComponent * numColorComponents;
    }

    public static void main(String[] args) {
        ColorDepthCalculator calculator = new ColorDepthCalculator();
        int bitsPerComponent = 8;
        int numColorComponents = 3;
        int bitsPerPixel = calculator.calculateBitsPerPixel(bitsPerComponent, numColorComponents);
        System.out.println("Bits per pixel: " + bitsPerPixel);
    }
}