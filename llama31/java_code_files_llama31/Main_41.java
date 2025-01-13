/*
 * Decompiled with CFR 0.152.
 */
import java.util.Scanner;

public class Main_41 {
    public static void main(String[] stringArray) {
        int n;
        int n2;
        Scanner scanner = new Scanner(System.in);
        int n3 = scanner.nextInt();
        int n4 = n2 = scanner.nextInt();
        int n5 = 0;
        int n6 = 0;
        int[] nArray = new int[n3];
        int[] nArray2 = new int[n3];
        for (n = 0; n < n3; ++n) {
            nArray[n] = scanner.nextInt();
        }
        for (n = 0; n < n3; ++n) {
            if (nArray[n] != n4) continue;
            ++n5;
            n6 = nArray[n];
        }
        for (n = 0; n < n3; ++n) {
            if (nArray[n] >= n2 || nArray[n] <= n6) continue;
            n6 = nArray[n];
        }
        if (n4 > n6) {
            System.out.println(n4);
        } else {
            System.out.println(n6);
        }
    }
}
