public class Main {
    static double ghostX;
    static double ghostY;
    static double dx;
    static double dy;

    public static void main(String[] args) {
        ghostX += dx;      // Update ghost's X position based on calculated angle and its speed
        ghostY += dy;      // Update ghost's Y position based on calculated angle and its speed
    }
}