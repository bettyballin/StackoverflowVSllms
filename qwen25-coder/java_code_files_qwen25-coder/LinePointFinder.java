import java.lang.String;
import java.util.Random;

public class LinePointFinder {
    public static void main(String[] args) {
        int x1 = 1952805748;
        int y1 = 0;
        int x2 = 7;
        int y2 = 142;

        // Generate a random t between 0 and 1
        Random rand = new Random();
        double t = rand.nextDouble();

        // Calculate the point (x3, y3)
        int x3 = (int) Math.round(x1 + t * (x2 - x1));
        int y3 = (int) Math.round(y1 + t * (y2 - y1));

        System.out.println("Random Point on Line: (" + x3 + ", " + y3 + ")");
    }
}