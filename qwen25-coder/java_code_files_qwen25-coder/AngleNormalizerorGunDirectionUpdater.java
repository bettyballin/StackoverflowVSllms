import java.lang.String;
public class AngleNormalizerorGunDirectionUpdater {
    int objdeg;
    int gundeg;
    int angleDifference = objdeg - gundeg;

    {
        // Normalize the angle difference to be within -180 and 180 degrees
        if (angleDifference > 180) {
            angleDifference -= 360;
        } else if (angleDifference < -180) {
            angleDifference += 360;
        }

        if (angleDifference > 0) {
            // Move clockwise
            gundeg++;
        } else if (angleDifference < 0) {
            // Move anticlockwise
            gundeg--;
        }
    }

    public static void main(String[] args) {
    }
}