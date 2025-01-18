import java.lang.String;
import java.util.Arrays;
import static java.lang.Math.*;

public class FrechetDistance {

    public double frechet(Coordinate[] P, Coordinate[] Q) {
        int m = P.length;
        int n = Q.length;
        double INF = Double.POSITIVE_INFINITY;

        // Create distance matrix with border values as infinity
        double[][] D = new double[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(D[i], INF);
        }

        // Initialize first column and row with border values
        D[1][0] = minDistance(P, Q, 0, -1);
        for (int j = 1; j <= n; j++) {
            D[0][j] = D[0][j - 1];
            if (D[0][j] > minDistance(P, Q, -1, j)) {
                D[0][j] = minDistance(P, Q, -1, j);
            }
        }

        // Compute interior points of distance matrix using dynamic programming logic
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                D[i][j] = minDistance(P, Q, i - 1, j);
                if (D[i][j] > minDistance(P, Q, i, j - 1)) {
                    D[i][j] = minDistance(P, Q, i, j - 1);
                } else if ((abs(P[i - 1].y - Q[j - 1].y) <= D[i][j])) {
                    D[i][j] = max(D[i - 1][j], D[i][j - 1]);
                }
            }
        }

        return D[m][n]; // Return final computed distance value from top right corner
    }

    public double minDistance(Coordinate[] P, Coordinate[] Q, int i, int j) {
        if (i < 0 || i >= P.length || j < 0 || j >= Q.length) {
            return Double.POSITIVE_INFINITY;
        } else {
            double dx = P[i].x - Q[j].x;
            double dy = P[i].y - Q[j].y;
            return sqrt(dx * dx + dy * dy);
        }
    }

    public static void main(String[] args) {
        // For testing purposes, you can add code here to test the frechet method
    }
}

class Coordinate {
    public double x;
    public double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }
}