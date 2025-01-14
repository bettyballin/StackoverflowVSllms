import java.lang.String;
public class TransitiveRelationChecker {
    public static boolean isTransitive(int[][] R) {
        int n = R.length; // Assuming R is a square matrix
        
        // Iterate over all pairs (a, b) and (b, c)
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (R[a][b] == 1) { // If there is an edge from a to b
                    for (int c = 0; c < n; c++) {
                        if (R[b][c] == 1 && R[a][c] == 0) { // If there is an edge from b to c but not from a to c
                            return false; // Relation is not transitive
                        }
                    }
                }
            }
        }
        
        return true; // Relation is transitive if no violations found
    }

    public static void main(String[] args) {
        int[][] relation = {
            {1, 0, 1},
            {0, 1, 1},
            {0, 0, 1}
        };
        
        System.out.println("Is the relation transitive? " + isTransitive(relation));
    }
}