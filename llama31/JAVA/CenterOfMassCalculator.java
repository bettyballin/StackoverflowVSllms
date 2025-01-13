import java.lang.String;
public class CenterOfMassCalculator {
    public static void calculateCenterOfMass(boolean[][] bitmap) {
        int sumX = 0;
        int sumY = 0;
        int totalPixels = 0;
        
        for (int y = 0; y < bitmap.length; y++) {
            for (int x = 0; x < bitmap[y].length; x++) {
                if (bitmap[y][x]) { // Assuming true represents an active pixel
                    sumX += x;
                    sumY += y;
                    totalPixels++;
                }
            }
        }
        
        if (totalPixels > 0) {
            double centerOfMassX = (double) sumX / totalPixels;
            double centerOfMassY = (double) sumY / totalPixels;
            System.out.println("Center of Mass: (" + centerOfMassX + ", " + centerOfMassY + ")");
        } else {
            System.out.println("No active pixels found.");
        }
    }
    
    public static void main(String[] args) {
        boolean[][] exampleBitmap = {
            {true, true, false, false},
            {false, true, true, false},
            {false, false, true, true},
            {false, false, false, true}
        };
        
        calculateCenterOfMass(exampleBitmap);
    }
}