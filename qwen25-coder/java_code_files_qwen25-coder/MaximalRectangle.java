import java.lang.String;
import java.lang.Integer;
import java.util.Deque;
import java.util.ArrayDeque;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int m = matrix.length; // number of rows
        int n = matrix[0].length; // number of columns
        
        int[] heights = new int[n];
        int maxArea = 0;
        
        for (int i = 0; i < m; i++) {
            // Update the heights array
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0; // Reset height if filled area
                }
            }
            
            // Calculate the maximum rectangle area from histogram formed by heights
            maxArea = Math.max(maxArea, largestRectangleInHistogram(heights));
        }
        
        return maxArea;
    }

    private static int largestRectangleInHistogram(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int index = 0;

        while (index < heights.length || !stack.isEmpty()) {
            if (index < heights.length && (stack.isEmpty() || heights[stack.peek()] <= heights[index])) {
                stack.push(index++);
            } else {
                int topOfStack = stack.pop();
                int area = (stack.isEmpty() ? index : index - stack.peek() - 1) * heights[topOfStack];
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {
            ".#....".toCharArray(),
            "......".toCharArray(),
            "...###".toCharArray(),
            "#.....".toCharArray(),
            "#.....".toCharArray(),
            "#####.".toCharArray()
        };
        
        System.out.println(maximalRectangle(matrix)); // Output will depend on the '1's representing empty spaces
    }
}