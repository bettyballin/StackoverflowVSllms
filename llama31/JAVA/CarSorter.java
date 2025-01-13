import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Car {
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

public class CarSorter {
    // Secure sorting using a stable sort algorithm
    public static void sortCars(Car[] result) {
        Collections.sort(Arrays.asList(result), Comparator.comparing(Car::getModel));
    }

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        Car[] cars = new Car[10];
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            car.setModel("Model " + random.nextInt(100));
            cars[i] = car;
        }
        sortCars(cars);
        for (Car car : cars) {
            System.out.println(car.getModel());
        }
    }
}