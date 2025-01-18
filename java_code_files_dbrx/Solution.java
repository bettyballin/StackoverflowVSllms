import java.util.*;

public class Solution {
    private List<Integer>[] map;

    @SuppressWarnings("unchecked")
    public int rowsNeeded(int n, List<String> hateRelations) {
        // Step 1: Create directed graph and calculate indegrees
        map = (List<Integer>[]) new List[n + 1];
        for (int i = 0; i <= n; ++i) {
            map[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];
        List<Integer> zeroIndegreeNodes = new ArrayList<>();

        for (String hl : hateRelations) {
            String[] splitStr = hl.split(" ");
            if (splitStr.length < 2) continue;
            Integer i = Integer.parseInt(splitStr[0]);
            Integer j = Integer.parseInt(splitStr[1]);

            if (!map[j].contains(i)) {
                map[j].add(i);
                indegree[i] += 1;
            }
        }

        for (int i = 1; i < indegree.length; ++i) {
            if (indegree[i] == 0) zeroIndegreeNodes.add(i);
        }

        // Step 2: Perform topological sort and assign students to rows
        int rowNumber = 1, totalRowsUsed = 0;

        while (!zeroIndegreeNodes.isEmpty()) {
            int numRemainingStudents = zeroIndegreeNodes.size();

            final int zeroDegreeNode = zeroIndegreeNodes.remove(0); // Dequeue and set current student to first in zero-degree queue

            if (numRemainingStudents > 1) {
                totalRowsUsed += rowNumber;
                rowNumber = 0; // Reset rows count since we're moving onto next group of nodes
            } else {
                rowNumber++;
            }

            for (Integer i : map[zeroDegreeNode]) {
                indegree[i]--;
                if (indegree[i] == 0) zeroIndegreeNodes.add(i); // Add any now degreeless students to queue
            }
        }

        return totalRowsUsed;
    }
}