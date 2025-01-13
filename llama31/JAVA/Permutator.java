public class Permutator {

    public static void permute(int[] T) {
        int n = T.length;
        for (int i = n - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int temp = T[i];
            T[i] = T[j];
            T[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] T = {3, 2, 0, 1};
        permute(T);
        for (int i = 0; i < T.length; i++) {
            System.out.print(T[i] + " ");
        }
    }
}