import java.util.List;
import java.util.Comparator;
import java.util.Collectors;
import java.util.ArrayList;

class Car {
    private int year;
    private String licensePlate;
    private String model;

    public Car(int year, String licensePlate, String model) {
        this.year = year;
        this.licensePlate = licensePlate;
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }
}

public class CarFilterAndSorter {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        // Add some cars to the list
        cars.add(new Car(1965, "AZ1234", "Mustang"));
        cars.add(new Car(1967, "AZ5678", "Camaro"));
        cars.add(new Car(1962, "CA9012", "Corvette"));
        cars.add(new Car(1969, "AZ1111", "Charger"));

        List<Car> result = cars.stream()
                .filter(car -> car.getYear() >= 1960 && car.getYear() < 1970)
                .filter(car -> car.getLicensePlate().startsWith("AZ"))
                .sorted(Comparator.comparing(Car::getModel))
                .collect(Collectors.toList());

        // Print the result
        result.forEach(car -> System.out.println(car.getModel()));
    }
}