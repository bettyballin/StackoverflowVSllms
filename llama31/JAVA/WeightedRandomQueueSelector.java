import java.lang.String;
import java.util.Random;

public class WeightedRandomQueueSelector {
    private Random random = new Random();
    private int[] weights;
    private int totalWeight;

    public WeightedRandomQueueSelector(int[] queueSizes) {
        weights = new int[queueSizes.length];
        totalWeight = 0;
        for (int i = 0; i < queueSizes.length; i++) {
            weights[i] = queueSizes[i];
            totalWeight += weights[i];
        }
    }

    public int selectQueue() {
        int randomWeight = random.nextInt(totalWeight);
        int cumulativeWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            cumulativeWeight += weights[i];
            if (randomWeight < cumulativeWeight) {
                return i;
            }
        }
        return weights.length - 1; // should never happen
    }

	public static void main(String[] args) {
	}
}