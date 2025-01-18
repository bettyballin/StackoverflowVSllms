import java.lang.String;
import java.util.Arrays;

public class PartitionFinder {
    public int solveRec(int[] numbers) {
        return helper(numbers, 0);
    }

    public int helper(int[] numbers, int i){
        if ((i >= numbers.length) || (Arrays.stream(numbers).sum() % 2 != 0)) { // If the total sum not even or array exhausted return -1 indicating no possible solution.
            return -1;
        } else {
            if (partOfArraySumExists(numbers, i)) {     // Check whether partition exists using partOfArraySumExists() helper function defined below.
                int n = numbers.length - i; // Get the length of remaining array that needs to be checked for equal sum partition.
                return n / 2 - 1;          /* If above function returns true, then position where partition would exist is at middle or close to it from right and its index can be returned.*/
            } else {  // If there is no valid partition in remaining array elements increment iterator to move onto the next element recursively.
                return helper(numbers, ++i);
            }
        }
    }

    public boolean partOfArraySumExists(int[] numbers, int index){
        /* Helper function for checking whether there exists a subsection of array whose total sum equals half of whole array's sum */
        int target = Arrays.stream(numbers).sum() / 2; // Target value to be achieved is half the overall array's total sum.
        int curSum = 0;   /* Counter to add all numbers from left-to-right up to current index as we traverse towards right side */
        for (int j = index; j < numbers.length; ++j) {    // Iterating over remaining part of array from current element moving rightwards.
            curSum += numbers[j];         /* Add each next number till last and check whenever its running total matches target half-sum value */
            if (curSum == target){  // If sum meets the desired partition condition for two equal partitions, return true.
                return true;       // End here and return control to main routine helper function indicating presence of possible solution.
            } else if (curSum > target) { /* Sum calculated from left-to-right in current partition exceeds target */
                break;           // Break and return false as partition is not possible starting from this index.
            }
        }
        return false; /* If no partition found during loop execution till end of remaining array elements then return false */
    }

    public static void main(String[] args) {
    }
}