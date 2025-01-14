import java.util.*;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class IdleTimeCalculator {

    public static int calculateIdleTime(List<Interval> jobs, int totalDuration) {
        if (jobs == null || jobs.isEmpty()) return totalDuration;

        // Sort intervals by start time
        Collections.sort(jobs, Comparator.comparingInt(a -> a.start));

        List<Interval> mergedIntervals = new ArrayList<>();
        Interval currentInterval = jobs.get(0);

        // Merge overlapping intervals
        for (int i = 1; i < jobs.size(); i++) {
            Interval nextInterval = jobs.get(i);
            if (currentInterval.end >= nextInterval.start) {
                // Overlapping intervals, merge them
                currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
            } else {
                // Non-overlapping interval found, add the current to merged list
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        // Add last interval
        mergedIntervals.add(currentInterval);

        // Calculate total work time from merged intervals
        int totalWorkTime = 0;
        for (Interval interval : mergedIntervals) {
            totalWorkTime += interval.end - interval.start;
        }

        // Idle time is the difference between total duration and total work time
        return Math.max(0, totalDuration - totalWorkTime);
    }

    public static void main(String[] args) {
        List<Interval> jobs = new ArrayList<>();
        jobs.add(new Interval(1, 3));
        jobs.add(new Interval(2, 5));
        jobs.add(new Interval(7, 8));

        int totalDuration = 10;

        int idleTime = calculateIdleTime(jobs, totalDuration);
        System.out.println("Total Idle Time: " + idleTime);
    }
}