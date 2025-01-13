import java.lang.String;
public class MajorityVote {
    public static String majorityVote(String[] votes) {
        String candidate = null;
        int count = 0;

        for (String vote : votes) {
            if (count == 0) {
                candidate = vote;
                count = 1;
            } else if (candidate.equals(vote)) {
                count++;
            } else {
                count--;
            }
        }

        // Confirm the majority element
        int occurrences = 0;
        for (String vote : votes) {
            if (vote.equals(candidate)) {
                occurrences++;
            }
        }

        return occurrences > votes.length / 2 ? candidate : null;
    }

    public static void main(String[] args) {
        String[] votes = {"A", "A", "A", "C", "C", "B", "B"};
        System.out.println(majorityVote(votes)); // null
    }
}