public class GhostMovement {
    public static void main(String[] args) {
        double ghostSpeed = 2.5F; // Adjust this value as needed for your game

        // Assuming angleRadians is provided or calculated elsewhere
        double angleDegrees = 45; // Example angle in degrees
        double angleRadians = Math.toRadians(angleDegrees); // Convert degrees to radians

        double dx = Math.cos(angleRadians) * ghostSpeed;   // Use radian version in calculations to avoid rounding errors
        double dy = Math.sin(angleRadians) * ghostSpeed;   // The speed is factored into the dx and dy adjustments

        // Output the results
        System.out.println("dx = " + dx);
        System.out.println("dy = " + dy);
    }
}