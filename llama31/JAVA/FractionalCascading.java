import java.util.*;

public class FractionalCascading {
    private List<List<Integer>> lists;
    private List<List<Integer>> bridges;

    public FractionalCascading(List<List<Integer>> lists) {
        this.lists = lists;
        this.bridges = new ArrayList<>();

        // Create L0 and bridges
        List<Integer> L0 = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            L0.add(lists.get(i).get(0));
            bridges.add(new ArrayList<>());
            bridges.get(i).add(lists.get(i).get(1));
        }

        // Recursively create L1, L2, ...
        createBridges(L0, bridges, 1);
    }

    private void createBridges(List<Integer> prevList, List<List<Integer>> bridges, int level) {
        if (level >= lists.size()) return;

        List<Integer> nextList = new ArrayList<>();
        for (int i = 0; i < prevList.size(); i++) {
            nextList.add(bridges.get(i).get(level - 1));
            if (level < lists.get(i).size()) {
                bridges.get(i).add(lists.get(i).get(level));
            }
        }

        createBridges(nextList, bridges, level + 1);
    }

    public List<Integer> locate(int[] items) {
        List<Integer> result = new ArrayList<>();
        for (int item : items) {
            int index = Collections.binarySearch(lists.get(0), item);
            if (index >= 0) {
                result.add(index);
                // Follow bridge pointers to find subsequent items
                for (int i = 1; i < lists.size(); i++) {
                    index = bridges.get(i - 1).get(index);
                    result.add(index);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 3, 5));
        lists.add(Arrays.asList(2, 4, 6));
        lists.add(Arrays.asList(7, 8, 9));

        FractionalCascading fc = new FractionalCascading(lists);
        int[] items = {3, 6};
        System.out.println(fc.locate(items));
    }
}