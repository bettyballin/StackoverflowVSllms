import java.lang.String;
public class Car_2 {
    // Private variable - information hiding.
    private int currentSpeed;

    // Constructor with abstraction - only essential properties included.
    public Car_2() {
        this.currentSpeed = 0;
    }

    // Encapsulation - providing getters and setters for controlled access.
    public void setSpeed(int speed) {
        if (speed >= 0) { // additional logic to prevent invalid states
            this.currentSpeed = speed;
        }
    }

    public int getSpeed() {
        return this.currentSpeed;
    }

    // Method abstraction - details of acceleration process are hidden.
    public void accelerate() {
        // Assume some complex acceleration mechanism here
        currentSpeed += 10;
    }

    public static void main(String[] args) {
    }
}