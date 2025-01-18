import java.util.Arrays;
public class StringDiff {
    public static int[] diff(String str1, String str2) {
        // initialize the matrix
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == 0 || len2 == 0) {
            return new int[]{};
        }
        int[][] diffs = new int[len1+1][len2+1];
        // first row and column are trivial cases
        for(int i = 0; i <= len1; ++i){
            diffs[i][0] = i;
        }
        for(int j = 0; j <= len2;++j) {
            diffs[0][j] = j;
        }
        // compute edit distances using Levenshtein's matrix algorithm
        int cost;
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <=len2 ;++j) {
                if (str1.charAt(i - 1) == str2.charAt(j-1)){
                    cost = 0;
                } else{
                    cost = 1; // any arbitrary nonzero value would work here; larger is better
                }
                diffs[i][j] = Math.min(cost + diffs[i - 1][j],   // deletion from str1
                        Math.min(Math.abs(len2-len1) + diffs[0][j],// just set the bigger string to the length of smaller one, if no diff possible
                                cost + diffs[i][j - 1]));    // insertion into str1
            }
        }
        int pos = len1;
        int result[] = new int[len2];
        for (int j=len2; j>0 && pos >0 ; --j) {
            if(diffs[pos][j] < diffs[pos-1][j]){
                result[--len2]= len2+1-(pos); // character is removed from str1 so add an insert position to the end of the "result" array
                pos--;
            } else if(diffs[pos][j] == diffs[pos][j-1]){
                j++; pos++;
            }else {// deletion in str2
                result[len2--] = len2+1 -(j); // character is removed from str2 so add a delete position into the end of "result" array
                --pos;
            }
        }
        return Arrays.copyOfRange(result, 0, len2);
    }

    public static void main(String[] args) {
    }
}