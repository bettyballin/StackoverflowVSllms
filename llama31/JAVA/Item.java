import java.util.ArrayList;
import java.util.List;

public class Item {
    int A;
    int B;
    int C;

    public Item(int A, int B, int C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
}

public class Main {
    public static void main(String[] args) {
        // Your lists of items
        List<Item>[] lists = new List[]{new ArrayList<>(), new ArrayList<>(), new ArrayList<>()};
        lists[0].add(new Item(1, 2, 3));
        lists[0].add(new Item(4, 5, 6));
        lists[1].add(new Item(7, 8, 9));
        lists[1].add(new Item(10, 11, 12));
        lists[2].add(new Item(13, 14, 15));
        lists[2].add(new Item(16, 17, 18));

        // The minimum sum of B
        int minB = 10;

        // The target sum of C
        int targetC = 20;

        // The maximum sum of A
        int maxA = findMaxA(lists, minB, targetC);

        System.out.println("Maximum sum of A: " + maxA);
    }

    public static int findMaxA(List<Item>[] lists, int minB, int targetC) {
        int[][][] dp = new int[lists.length + 1][minB + 1][targetC + 1];

        for (int i = 0; i <= lists.length; i++) {
            for (int j = 0; j <= minB; j++) {
                for (int k = 0; k <= targetC; k++) {
                    if (i == 0) {
                        // Initialize the base case
                        dp[i][j][k] = 0;
                    } else {
                        // For each item in the current list
                        for (Item item : lists[i - 1]) {
                            // If the item's B value is less than or equal to the current sum of B
                            // and the item's C value is less than or equal to the target sum of C
                            if (item.B <= j && item.C <= k) {
                                // Choose the maximum sum of A
                                dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - item.B][k - item.C] + item.A);
                            }
                        }
                        // Also consider the case where we don't choose any item from the current list
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
                    }
                }
            }
        }

        // The maximum sum of A is stored in the last cell of the dynamic programming table
        return dp[lists.length][minB][targetC];
    }
}