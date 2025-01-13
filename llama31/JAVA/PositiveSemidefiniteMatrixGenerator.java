import java.lang.String;
import java.util.Random;

public class PositiveSemidefiniteMatrixGenerator {
    public static void main(String[] args) {
        int n = 5; // desired dimension
        Random rand = new Random();

        // Generate a random matrix A
        double[][] A = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = rand.nextDouble();
            }
        }

        // Compute A^T * A
        double[][] ATA = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ATA[i][j] += A[k][i] * A[k][j];
                }
            }
        }

        // Print the resulting matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ATA[i][j] + " ");
            }
            System.out.println();
        }
    }
}