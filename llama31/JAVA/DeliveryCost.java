import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DeliveryCost {

    private int cost;
    private int[] deliveries;

    private DeliveryCost(int[] deliveries) {
        this.deliveries = deliveries;
    }

    public static void main(String[] args) {
        int[] deliveries = { 2, 3, 5, 6, 1, 8, 10, 4, 9, 7 };
        int[] sortedDeliveries = Arrays.copyOf(deliveries, deliveries.length);
        Arrays.sort(sortedDeliveries);
        System.out.println("Best order: " + Arrays.toString(sortedDeliveries));
        int[] bestPermutation = permutations(deliveries);
        System.out.println("Best permutation: " + Arrays.toString(bestPermutation));
    }

    private static int[] permutations(int[] deliveries) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<int[]>> futures = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Future<int[]> future = executorService.submit(() -> {
                int[] tempDeliveries = Arrays.copyOf(deliveries, deliveries.length);
                int[] permutation = permute(tempDeliveries, tempDeliveries.length, finalI);
                return permutation;
            });
            futures.add(future);
        }
        int[] bestPermutation = null;
        int bestCost = Integer.MAX_VALUE;
        for (Future<int[]> future : futures) {
            try {
                int[] permutation = future.get();
                int cost = cost(permutation);
                if (cost < bestCost) {
                    bestPermutation = permutation;
                    bestCost = cost;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        return bestPermutation;
    }

    private static int[] permute(int[] arr, int n, int i) {
        if (i == n) {
            int cost = cost(arr);
            System.out.println("Permutation " + Arrays.toString(arr) + " cost: " + cost);
        } else {
            for (int j = i; j < n; j++) {
                int[] temp = Arrays.copyOf(arr, arr.length);
                temp[i] = arr[j];
                temp[j] = arr[i];
                permute(temp, n, i + 1);
            }
        }
        return arr;
    }

    private static int cost(int[] deliveries) {
        int cost = 0;
        for (int i = 1; i < deliveries.length; i++) {
            int changeOfDirection = deliveries[i] < deliveries[i - 1] ? 3 : 1;
            cost += (changeOfDirection * (deliveries[i] - deliveries[i - 1]) * (deliveries[i] - deliveries[i - 1]));
        }
        return cost;
    }
}