import java.util.*;
import java.util.stream.*;

public class GroupAllocator {
    public static List<List<Integer>> allocateToGroups(List<Integer> numbers, int N) {
        // Sort numbers in descending order
        Collections.sort(numbers, Collections.reverseOrder());

        // Initialize lists for groups
        List<List<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            groups.add(new ArrayList<>());
        }

        // First Fit Decreasing approach
        int[] groupSums = new int[N];
        for (int number : numbers) {
            boolean placed = false;
            for (int i = 0; i < N && !placed; i++) {
                int maxSum = IntStream.of(groupSums).max().orElse(0);
                if (groupSums[i] + number <= maxSum || IntStream.of(groupSums).allMatch(x -> x == groupSums[0])) {
                    groups.get(i).add(number);
                    groupSums[i] += number;
                    placed = true;
                }
            }
            // If not placed, add to the group with the smallest sum
            if (!placed) {
                int minIndex = IntStream.range(0, N).reduce((a, b) -> groupSums[a] < groupSums[b] ? a : b).orElse(0);
                groups.get(minIndex).add(number);
                groupSums[minIndex] += number;
            }
        }

        // Backtracking to minimize the difference
        boolean improved;
        do {
            improved = false;
            for (int i = 0; i < N; i++) {
                for (int j = groups.get(i).size() - 1; j >= 0; j--) {
                    int tempNumber = groups.get(i).remove(j);
                    groupSums[i] -= tempNumber;

                    boolean newPlacementFound = false;
                    for (int k = 0; k < N && !newPlacementFound; k++) {
                        if (k != i) {
                            int maxSum = IntStream.of(groupSums).max().orElse(0);
                            if (groupSums[k] + tempNumber <= maxSum) {
                                groups.get(k).add(tempNumber);
                                groupSums[k] += tempNumber;
                                newPlacementFound = true;
                                improved = true;
                            }
                        }
                    }

                    if (!newPlacementFound) {
                        groups.get(i).add(tempNumber);
                        groupSums[i] += tempNumber;
                    }
                }
            }
        } while (improved);

        return groups;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(7, 7, 8, 8, 8, 9, 9, 10);
        int N = 3;
        List<List<Integer>> result = allocateToGroups(numbers, N);

        for (int i = 0; i < result.size(); i++) {
            int sum = result.get(i).stream().mapToInt(n -> n).sum();
            System.out.println("Group " + (char) ('A' + i) + ": " + result.get(i) + " sum: " + sum);
        }
    }
}