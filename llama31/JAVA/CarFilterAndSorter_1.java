import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

// Define a Car class for demonstration purposes
class Car {
    private int year;
    private String model;
    private String licensePlate;

    public Car(int year, String model, String licensePlate) {
        this.year = year;
        this.model = model;
        this.licensePlate = licensePlate;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}

public class CarFilterAndSorter_1_1 {
    public static void main(String[] args) {
        // Create a list of cars for demonstration purposes
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1965, "Mustang", "AZ123"));
        cars.add(new Car(1968, "Camaro", "AZ456"));
        cars.add(new Car(1972, "Charger", "CA789"));
        cars.add(new Car(1962, "Corvette", "AZ901"));

        // Define the predicate
        Predicate<Car> predicate = car -> car.getYear() >= 1960 && car.getYear() < 1970 && car.getLicensePlate().startsWith("AZ");

        // Filter the list
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (predicate.test(car)) {
                result.add(car);
            }
        }

        // Sort the result
        Collections.sort(result, Comparator.comparing(Car::getModel));

        // Print the result for demonstration purposes
        for (Car car : result) {
            System.out.println("Year: " + car.getYear() + ", Model: " + car.getModel() + ", License Plate: " + car.getLicensePlate());
        }
    }
}