import java.util.ArrayList;
import java.util.List;

public class BoxSizeCalculator {

    public static List<Integer> calculateBoxSizes(int viewportWidth, int numberOfBoxes) {
        double ratio = 0.9; // Each box is 10% smaller than the previous one
        double sumOfRatios = (1 - Math.pow(ratio, numberOfBoxes)) / (1 - ratio); // Sum of geometric series

        List<Integer> boxWidths = new ArrayList<>();
        double currentSize = viewportWidth / sumOfRatios; // Initial size to fit all boxes in the viewport

        for (int i = 0; i < numberOfBoxes; i++) {
            int width = (int) Math.round(currentSize);
            boxWidths.add(width);
            currentSize *= ratio; // Decrease size by 10% for the next box
            viewportWidth -= width; // Adjust remaining space in the viewport

            // Ensure the last box fits exactly if there's a fractional part left
            if (i == numberOfBoxes - 2) {
                int lastBoxWidth = Math.max(1, viewportWidth);
                boxWidths.add(lastBoxWidth);
                break;
            }
        }

        return boxWidths;
    }

    public static void main(String[] args) {
        int viewportWidth = 271;
        int numberOfBoxes = 3;
        List<Integer> sizes = calculateBoxSizes(viewportWidth, numberOfBoxes);
        System.out.println(sizes); // Output: [100, 90, 81]
    }
}