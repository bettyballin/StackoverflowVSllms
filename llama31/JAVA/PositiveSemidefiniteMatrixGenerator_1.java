import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class PositiveSemidefiniteMatrixGenerator_1_1 {
    public static void main(String[] args) {
        int n = 5; // desired dimension
        RealMatrix A = new Array2DRowRealMatrix(n, n);
        A = A.scalarMultiply(0.5); // scale to ensure positive-semidefiniteness
        RealMatrix ATA = A.transpose().multiply(A);
        System.out.println(ATA);
    }
}