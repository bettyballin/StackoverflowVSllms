import java.lang.String;
public class MajorityElementFinder {
    // Function to implement Moore's voting algorithm to find element with count more than n / 2
    public static int majorityElement(int arr[], int size) {
        // Initializes candidate and its frequency
        int res = 0, count = 1;

        for (int i = 1; i < size; i++) {
            if (count == 0) {
                res = arr[i];
                count++;
            } else if (arr[res] == arr[i])
                count++;
            else
                count--;
        }

        return arr[res];
    }

    public static void main(String[] args) {
    }
}