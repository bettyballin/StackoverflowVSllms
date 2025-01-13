import java.lang.String;
public class ImageSegmentation {
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1, 2, 2}, 
                         {1, 1, 1, 2, 2}, 
                         {3, 3, 3, 4, 4}, 
                         {3, 3, 3, 4, 4}};

        int[][] labeledImage = segmentImage(image);
        for (int i = 0; i < labeledImage.length; i++) {
            for (int j = 0; j < labeledImage[i].length; j++) {
                System.out.print(labeledImage[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] segmentImage(int[][] image) {
        int width = image[0].length;
        int height = image.length;

        int[][] labeledImage = new int[height][width];
        int label = 1;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (labeledImage[y][x] == 0) {
                    floodFill(image, labeledImage, x, y, label, image[y][x]);
                    label++;
                }
            }
        }

        return labeledImage;
    }

    public static void floodFill(int[][] image, int[][] labeledImage, int x, int y, int label, int value) {
        if (x < 0 || x >= image[0].length || y < 0 || y >= image.length) {
            return;
        }

        if (labeledImage[y][x] != 0 || image[y][x] != value) {
            return;
        }

        labeledImage[y][x] = label;

        floodFill(image, labeledImage, x - 1, y, label, value);
        floodFill(image, labeledImage, x + 1, y, label, value);
        floodFill(image, labeledImage, x, y - 1, label, value);
        floodFill(image, labeledImage, x, y + 1, label, value);
    }
}