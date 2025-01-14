public class SpaceCalculator {
    // Advertised space in decimal GB
    double advertisedGB = 80;
    
    // Convert advertised space to megabytes (base 10)
    long advertisedMB = (long) (advertisedGB * 1000);
    
    // Convert advertised space to binary GB and then to MB
    long actualBinaryGB = (long) (advertisedGB / Math.pow(2, 30) * Math.pow(2, 30));
    long actualBinaryMB = (long) (actualBinaryGB * 1024);
    
    // Calculate difference in megabytes
    long differenceMB = advertisedMB - actualBinaryMB;
    
    public static void main(String[] args) {
        new SpaceCalculator();
    }
    
    public SpaceCalculator() {
        System.out.println("Advertised space in MB: " + advertisedMB);
        System.out.println("Actual binary GB space converted to MB: " + actualBinaryMB);
        System.out.println("Difference in MB: " + differenceMB);
    }
}