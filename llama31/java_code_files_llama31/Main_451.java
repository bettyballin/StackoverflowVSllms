/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_451 {
    public static void main(String[] stringArray) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] nArray = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            nArray[i] = Integer.parseInt(bufferedReader.readLine());
        }
        int[] nArray2 = new int[n + 1];
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            nArray2[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nArray[i] <= nArray[j]) continue;
                nArray2[i] = Math.max(nArray2[i], nArray2[j] + 1);
            }
            n2 = Math.max(n2, nArray2[i]);
        }
        bufferedWriter.write("" + n2);
        bufferedWriter.flush();
    }
}
