public class TimeCalculator_1_1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis() + 86400000; // example end time (1 day later)

        long timeInSeconds = (endTime - startTime) / 1000;
        long minutes = timeInSeconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        String time = String.format("%d days, %02d hours, %02d minutes, %02d seconds",
            days, hours % 24, minutes % 60, timeInSeconds % 60);

        System.out.println(time);
    }
}