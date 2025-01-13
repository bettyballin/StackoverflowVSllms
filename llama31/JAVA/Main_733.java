import java.util.Arrays;

public class Main_733 {
    public static void main(String[] args) {
        String[][] table = {{"1", "2", "3"}, {"4", "5", "6"}};
        String[][] finalData = Arrays.stream(table)
                .map(row -> row.clone())
                .toArray(String[][]::new);
        System.out.println(Arrays.deepToString(finalData));
    }
}