public class AngleNormalizer {
    static double angleDegrees;
    static double angleRadians;

    static {
        angleDegrees = Math.toDegrees(angleRadians) % 360;
        if(angleDegrees < 0) { angleDegrees += 360; }
    }
    
    public static void main(String[] args) {
    }
}