/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class PrimeGenerator {
    public static ArrayList<Integer> generatePrimes(int n) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        boolean[] blArray = new boolean[n * 10];
        Arrays.fill(blArray, true);
        blArray[1] = false;
        blArray[0] = false;
        int n2 = 2;
        while (n2 * n2 < blArray.length) {
            if (blArray[n2]) {
                for (int i = n2 * n2; i < blArray.length; i += n2) {
                    blArray[i] = false;
                }
            }
            ++n2;
        }
        n2 = 2;
        while (arrayList.size() < n) {
            if (blArray[n2]) {
                arrayList.add(n2);
            }
            ++n2;
        }
        return arrayList;
    }

    public static void main(String[] stringArray) {
        ArrayList<Integer> arrayList = PrimeGenerator.generatePrimes(10);
        System.out.println(arrayList);
    }
}
