/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class ExpenseSharing {
    public static void main(String[] stringArray) {
        int[] nArray = new int[]{400, 1000, 100};
        int[] nArray2 = ExpenseSharing.settleExpenses(nArray);
        ExpenseSharing.printSettlements(nArray2);
    }

    public static int[] settleExpenses(int[] nArray) {
        int n;
        int n2;
        int n3 = 0;
        int[] nArray2 = nArray;
        int n4 = nArray2.length;
        for (n2 = 0; n2 < n4; ++n2) {
            n = nArray2[n2];
            n3 += n;
        }
        int n5 = n3 / nArray.length;
        int[] nArray3 = new int[nArray.length];
        for (n2 = 0; n2 < nArray.length; ++n2) {
            nArray3[n2] = nArray[n2] - n5;
        }
        Arrays.sort(nArray3);
        int[] nArray4 = new int[nArray3.length];
        n = 0;
        int n6 = nArray3.length - 1;
        while (n < n6) {
            int n7;
            nArray4[n] = n7 = Math.min(-nArray3[n], nArray3[n6]);
            nArray4[n6] = -n7;
            int n8 = n;
            nArray3[n8] = nArray3[n8] + n7;
            int n9 = n6;
            nArray3[n9] = nArray3[n9] - n7;
            if (nArray3[n] == 0) {
                ++n;
            }
            if (nArray3[n6] != 0) continue;
            --n6;
        }
        return nArray4;
    }

    public static void printSettlements(int[] nArray) {
        for (int i = 0; i < nArray.length; ++i) {
            if (nArray[i] <= 0) continue;
            System.out.println("Person " + (i + 1) + " pays " + nArray[i] + " to person " + (nArray.length - i));
        }
    }
}
