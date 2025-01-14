import java.lang.String;
public class Downsampler1D {
    // Example of 1D downscaling by averaging every two points
    static int[] original = {1, 2, 3, 4, 5, 6};
    static double[] downscaled = new double[original.length / 2];
    
    static {
        for (int i = 0; i < downscaled.length; i++) {
            int index = i * 2;
            downscaled[i] = (original[index] + original[index + 1]) / 2.0;
        }
    }
    
    public static void main(String[] args) {
    }
}