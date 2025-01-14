import java.lang.String;
public class MarbleDropping {
    public static int findCriticalFloor(int floors, int marbles) {
        // Determine the optimal initial step size
        int stepSize = (int) Math.sqrt(2 * floors);
        while ((stepSize * (stepSize + 1)) / 2 < floors) {
            stepSize++;
        }

        int currentFloor = 0;
        int firstMarbleBreaksAt = -1;

        // Drop the first marble
        for (; currentFloor + stepSize <= floors; currentFloor += stepSize) {
            if (wouldBreak(currentFloor + stepSize)) {
                firstMarbleBreaksAt = currentFloor + stepSize;
                break;
            }
        }

        // If first marble didn't break, it means the critical floor is above last non-breaking floor
        if (firstMarbleBreaksAt == -1) {
            firstMarbleBreaksAt = floors + 1;
        }

        // Use second marble to check each floor starting from one above where first marble broke
        for (int i = currentFloor - stepSize + 1; i < firstMarbleBreaksAt; i++) {
            if (wouldBreak(i)) {
                return i;
            }
        }

        // If no floor made the second marble break, it means it's the top floor
        return floors;
    }

    // Dummy function to simulate if a marble would break at a given floor
    private static boolean wouldBreak(int floor) {
        int criticalFloor = 50; // Example randomly chosen critical floor
        return floor >= criticalFloor;
    }

    public static void main(String[] args) {
        int floors = 100;
        int marbles = 2;
        int criticalFloor = findCriticalFloor(floors, marbles);
        System.out.println("The critical floor is: " + criticalFloor);
    }
}