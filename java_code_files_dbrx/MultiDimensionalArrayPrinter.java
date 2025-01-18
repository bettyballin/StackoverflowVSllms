import java.lang.String;
public class MultiDimensionalArrayPrinter {
    int[][] arr = {{1, 2, 3}, {4, 5, 6, 7, 8, 9, 9, 9}, {5, 4, 3, 2}};
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++){
                System.out.println(arr[i][j]);
            }
        }
    }
    public static void main(String[] args) {
        new MultiDimensionalArrayPrinter();
    }
}