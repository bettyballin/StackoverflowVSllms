/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DeliveryCost {
    private int cost;
    private int[] deliveries;

    private DeliveryCost(int[] nArray) {
        this.deliveries = nArray;
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{2, 3, 5, 6, 1, 8, 10, 4, 9, 7};
        int[] nArray2 = Arrays.copyOf(nArray, nArray.length);
        Arrays.sort(nArray2);
        System.out.println("Best order: " + Arrays.toString(nArray2));
        int[] nArray3 = DeliveryCost.permutations(nArray);
        System.out.println("Best permutation: " + Arrays.toString(nArray3));
    }

    private static int[] permutations(int[] nArray) {
        int n;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ArrayList<Object> arrayList = new ArrayList<Object>(10);
        int n2 = 0;
        while (n2 < 10) {
            n = n2++;
            Future<int[]> future = executorService.submit(() -> {
                int[] nArray2 = Arrays.copyOf(nArray, nArray.length);
                int[] nArray3 = DeliveryCost.permute(nArray2, nArray2.length, n);
                return nArray3;
            });
            arrayList.add(future);
        }
        int[] nArray2 = null;
        n = Integer.MAX_VALUE;
        for (Future future : arrayList) {
            try {
                int[] nArray3 = (int[])future.get();
                int n3 = DeliveryCost.cost(nArray3);
                if (n3 >= n) continue;
                nArray2 = nArray3;
                n = n3;
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            catch (ExecutionException executionException) {
                executionException.printStackTrace();
            }
        }
        executorService.shutdown();
        return nArray2;
    }

    private static int[] permute(int[] nArray, int n, int n2) {
        if (n2 == n) {
            int n3 = DeliveryCost.cost(nArray);
            System.out.println("Permutation " + Arrays.toString(nArray) + " cost: " + n3);
        } else {
            for (int i = n2; i < n; ++i) {
                int[] nArray2 = Arrays.copyOf(nArray, nArray.length);
                nArray2[n2] = nArray[i];
                nArray2[i] = nArray[n2];
                DeliveryCost.permute(nArray2, n, n2 + 1);
            }
        }
        return nArray;
    }

    private static int cost(int[] nArray) {
        int n = 0;
        for (int i = 1; i < nArray.length; ++i) {
            int n2 = nArray[i] < nArray[i - 1] ? 3 : 1;
            n += n2 * (nArray[i] - nArray[i - 1]) * (nArray[i] - nArray[i - 1]);
        }
        return n;
    }
}
