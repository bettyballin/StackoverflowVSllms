import java.util.Random;

class WeightedRandomQueueSelector {
    private int[] queueSizes;
    private Random random;

    public WeightedRandomQueueSelector(int[] queueSizes) {
        this.queueSizes = queueSizes;
        this.random = new Random();
    }

    public int selectQueue() {
        int sum = 0;
        for (int size : queueSizes) {
            sum += size;
        }
        int randomInt = random.nextInt(sum);
        int cumulativeSum = 0;
        for (int i = 0; i < queueSizes.length; i++) {
            cumulativeSum += queueSizes[i];
            if (randomInt < cumulativeSum) {
                return i;
            }
        }
        return queueSizes.length - 1;
    }
}

public class WeightedRandomQueueSelector_1_1 {
    public static void main(String[] args) {
        int[] queueSizes = new int[] {10, 20, 30, 40, 50};
        WeightedRandomQueueSelector selector = new WeightedRandomQueueSelector(queueSizes);
        int nextQueue = selector.selectQueue();
        System.out.println(nextQueue);
    }
}