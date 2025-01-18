public class CollisionTest {

    enum Direction {
        top, bottom, left, right, front, back;  // cube bounding sides
    }

    public static void main(String[] args) {
        // Define your cube's minimum and maximum points as (xmin, ymin, zmin) and (xmax, ymax, zmax) respectively.
        int xmin = 0, ymin = 0, zmin = 0;
        int xmax = 10, ymax = 10, zmax = 10;

        // Create ball
        Vector3 ballPosition = new Vector3(5, 5, 5);
        Vector3 directionVector = new Vector3(1, 0, 0); // Example direction vector

        BallSphere ballSphere = new BallSphere(4); // Example radius
        int halfBallRadius = ballSphere.getRadius() / 2;

        boolean isInXRange = false;
        if (ballPosition.x - halfBallRadius > xmin && ballPosition.x + halfBallRadius < xmax) {
            isInXRange = true; // in range, no need to check for collision across x-axis planes
        } else if (Math.abs(directionVector.x) > 0) { // direction of velocity towards this plane
            int delta = 0;

            // Check left / right collision
            if (ballPosition.x - halfBallRadius < xmin) { // ball collides with the left bounding box edge
                delta = (int) Math.max(ballPosition.x + halfBallRadius, Math.max(halfBallRadius, xmin));  // Calculate amount to move ball away from the collision
            } else if (ballPosition.x + halfBallRadius > xmax) {
                delta = -(int) Math.max(ballPosition.x - halfBallRadius, Math.max(-halfBallRadius, xmax));
            }
            ballPosition = ballPosition.add(new Vector3(delta, 0, 0)); // move out of the side
        } else {
            // Handle collision on remaining sides
        }
    }
}

class BallSphere {
    private int radius;

    public BallSphere(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
}

class Vector3 {
    public double x, y, z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    } 

    // Add method to add another vector
    public Vector3 add(Vector3 v) {
        return new Vector3(x + v.x, y + v.y, z + v.z);
    }
}