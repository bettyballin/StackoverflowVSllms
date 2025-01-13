import java.lang.String;
public class LeadersOfArray {
    public static void findLeaders(int[] arr) {
        int n = arr.length;
        int maxFromRight = arr[n-1];
        System.out.print(maxFromRight + " "); // last element is always a leader

        for (int i = n-2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                System.out.print(maxFromRight + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 6};
        findLeaders(arr);
    }
}