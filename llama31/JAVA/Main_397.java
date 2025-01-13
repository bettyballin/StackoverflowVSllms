public class Main_397 {
    public static void main(String[] args) {
        int i = 10; // some value for i
        int[][] l = new int[i][i]; // some 2D array
        int pk = 1; // some value for pk
        int pj = 2; // some value for pj

        // Initialize the 2D array with some values
        for (int x = 0; x < i; x++) {
            for (int y = 0; y < i; y++) {
                l[x][y] = x + y; // some example values
            }
        }

        int min = Integer.MAX_VALUE;
        for (int k = 1; k < i; k++) {
            int tmp = l[k][i-1] + dist(pk, pj); // note: array indices start at 0
            if (tmp < min) {
                min = tmp;
            }
        }
        System.out.println(min); // print the result
    }

    public static int dist(int pk, int pj) {
        // some implementation for dist function
        return Math.abs(pk - pj); // example implementation
    }
}