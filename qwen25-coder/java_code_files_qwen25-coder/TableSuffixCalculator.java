import java.lang.String;
import java.lang.Math;
public class TableSuffixCalculator {
    public int getTableSuffix(String userAccount, int N) {
        // Ensure a non-negative value by converting the hashCode to a positive integer
        int hash = Math.abs(userAccount.hashCode());
        
        // Return the suffix by applying modulo operation with N
        return (hash % N) + 1;
    }
    public static void main(String[] args) {
    }
}