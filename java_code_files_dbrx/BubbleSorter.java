import java.lang.String;
import java.lang.Integer;
public class BubbleSorter {
    public static void sortList(int[] arr){
        for (int i = arr.length - 1; i > 0; --i) {
            boolean swapped = false;
            int maxUnsortedIndex = 0; // initialize to 0
            int tempNum = Integer.MIN_VALUE; // this is the one extra integer variable you can use, initialized to smallest possible number

            for (int j = 0; j < i; ++j) {
                if (arr[j] > arr[maxUnsortedIndex]) {   // find max unsorted value so far
                    tempNum = arr[j];                   // store it in the only extra integer variable allowed
                    maxUnsortedIndex = j;              // keep its index for later use during swap (step 2)
                } else if ((arr[maxUnsortedIndex] > arr[j + 1])) {    // check if a swap is needed between current and next element (step 2)
                    swapped = true;                     // indicate if we made any successful swaps in this iter
                    int temp = arr[j+1];                   // start the swap process with two integer variables...
                    arr[j + 1] = tempNum;            // ...swapping arr[maxUnsortedIndex] (stored previously) into correct position arr[j+1]
                    tempNum = arr[j];                    // then update next-to-last swapped value (temp in previous line), keeping within allowed integer size of 'tempNum' variable
                }
            }
            if (!swapped){           // check if we made any successful swaps this iteration round; if not, array is sorted and we can terminate early with break statement
                return;      // if sorting order is already fulfilled at inner loop level i (or "i" iterations), quit the loop to increase execution speed by avoiding unnecessary outer loops.
            } else {             // otherwise, continue iterating in case array isn't fully sorted yet.
                while(maxUnsortedIndex > 0) {     // ensure we properly handled final number swap in last 'i-j' iteration round
                    if ((arr[maxUnsortedIndex - 1] > tempNum) ) {     // do final swaps required before moving onto next 'i' iteration round
                        int temp = arr[maxUnsortedIndex];              // start the swap process with two integer variables...
                        arr[maxUnsortedIndex--] = tempNum;          // finish up the last j-iteration round of this i outer loop
                        tempNum = arr[maxUnsortedIndex];           // then update 'tempNum' with newly indexed number for following swap operation.
                    } else {   // break out of while loop; no more swaps needed in this i-iteration round
                        break;          // end the final nested "while" loop prematurely if no more successful array element swapping possible
                    }   // end of while conditionals section
                }   // close out 'if-else' conditional statement
            }  // end Bubble Sort process
        }   // close entire routine
    }  // final Bubble Sort algorithm function

    public static void main(String[] args) {
    }
}