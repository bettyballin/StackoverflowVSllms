import java.lang.String;
public class for_1 {
    // Proper use of class for encapsulation and representing a concept
    class Vehicle {
        private String make;
        private int year;

        public Vehicle(String make, int year) {
            this.make = make;
            this.year = year;
        }

        public void displayInfo() {
            System.out.println("Vehicle: " + make + ", Year: " + year);
        }
    }

    // Improper use of class - unnecessary abstraction
    class Color {
        private String hexCode;

        public Color(String hexCode) {
            this.hexCode = hexCode;
        }

        public String getHexCode() {
            return hexCode;
        }
    }
    public static void main(String[] args) {
    }
}