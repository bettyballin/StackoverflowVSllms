import java.lang.String;
public class InPlacePermutationEncoder {
    public void permuteArray(int[] T) {
        int n = T.length;
        
        // First pass: encode both old and new values into each entry
        for (int i = 0; i < n; i++) {
            int oldVal = T[i];
            int newValAtOldIndex = T[oldVal] % n;
            T[i] = oldVal + newValAtOldIndex * n;
        }
        
        // Second pass: decode the new values and write them in place
        for (int i = 0; i < n; i++) {
            T[i] /= n;
        }
    }
    public static void main(String[] args) {
    }
}