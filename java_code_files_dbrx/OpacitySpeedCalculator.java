import java.lang.String;
public class OpacitySpeedCalculator {
    double max = 10.0; // your maximum limit for speed X
    double min = 1.0; // your minimum limit for speed X
    double lowest_opacity = 0.005; // the slowest increment (for X=min)
    double highest_opacity = 0.1; // the fastest increment (for X=max)

    public double calculateOpacitySpeed(double speedX) {
        return (((speedX - min) * (highest_opacity - lowest_opacity)) / (max - min)) + lowest_opacity;
    }

    public static void main(String[] args) {
    }
}