import java.lang.String;

public class RelationValidator {
    public boolean isTransitive(boolean[][] matrix) {
        int n = matrix.length;
        boolean[][] transitiveClosure = new boolean[n][n];

        // Initialize transitiveClosure with the original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transitiveClosure[i][j] = matrix[i][j];
            }
        }

        // Compute the transitive closure
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]) {
                    for (int k = 0; k < n; k++) {
                        if (matrix[j][k]) {
                            transitiveClosure[i][k] = true;
                        }
                    }
                }
            }
        }

        // Compare the transitiveClosure with the original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (transitiveClosure[i][j] != matrix[i][j]) {
                    return false; // Relation is not transitive
                }
            }
        }

        return true; // Relation is transitive
    }

    public static void main(String[] args) {
        RelationValidator validator = new RelationValidator();
        boolean[][] matrix = {
            {true, true, false},
            {false, true, true},
            {false, false, true}
        };
        System.out.println(validator.isTransitive(matrix)); // prints: true
    }
}