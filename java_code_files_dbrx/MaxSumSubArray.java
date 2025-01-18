import java.lang.String;
import java.lang.Integer;
public class MaxSumSubArray {
    public int maxSum(int[] array) {
        if (array == null || array.length < 1) return -1;
        int soFar = 0, best = Integer.MIN_VALUE;
        for(int i = 0; i<array.length ; ++i ) {
            // compute max sum till the end of the array including a[i] as last element of subarray
            soFar += array[i];
            // check whether current subarray (including a[i]) is better than all previous ones encountered
            if(soFar > best) {
                best = soFar;
            }else{
                // keep track of the max sum sofar while encountering negative integers in array
                // which might spoil overall maxSum by ending subarray earlier, as their cummulative value is positive.
                if(soFar < 0) {
                    soFar = 0;
                }
            }
        }
        return best;
    }

	public static void main(String[] args) {
	}
}