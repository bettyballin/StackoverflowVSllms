import java.lang.String;
import java.lang.Math; //Import Math class to get access to Math functions

public class Main_61 {
    public static void main(String[] args) {
        int x1 = 2, y1 = 50, x2 = 9, y2 = 40, x3 = 5, y3 = 20; //Point coordinates (P1 to P3)

        double angleRadians; //Angle in radians
        double angleDegrees; //Converted angle in degrees

        int dx2 = x2 - x1; //Get delta X for point 2 from center Point P1
        int dy2 = y2 - y1; //Get delta Y for point 2 from center Point P1

        int dx3 = x3 - x1; //Get delta X for point 3 from center Point P1
        int dy3 = y3 - y1; //Get delta Y for point 3 from center Point P1

//Calculate the dot product of two vectors P1P2 and P1P3 to find cosine value
        double dotProduct = (dx2 * dx3 + dy2 * dy3);

//Find magnitudes using the formula square root of ((delta X squared) +( delta Y squared)) for denominator
        double magnitude2 = Math.hypot((x2 - x1), (y2 - y1));
        double magnitude3 = Math.hypot((x3 - x1), (y3 - y1));
//Find the dot product divided by product of magnitudes for final cosine value
        angleRadians = Math.acos(dotProduct / ((magnitude2) * (magnitude3))); //Calculate in radians

/* Convert from Radian to Degree as arc tangent returns result in Radian.
So, multiple it with 180/(pi) */
        angleDegrees = Math.toDegrees(angleRadians);

//Print final answer and also convert to [0,360] interval if needed
        System.out.println("The calculated angle in degrees is: " + angleDegrees);
    }
}