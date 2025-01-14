import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

class Car {
    String makeYear;
    String licensePlate;
    String modelName;

    public Car(String makeYear, String licensePlate, String modelName) {
        this.makeYear = makeYear;
        this.licensePlate = licensePlate;
        this.modelName = modelName;
    }

    // Getters
    public String getMakeYear() { return makeYear; }
    public String getLicensePlate() { return licensePlate; }
    public String getModelName() { return modelName; }
}

public class Main_122 {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("1965", "AZ12345", "Camaro"));
        cars.add(new Car("1968", "BX78901", "Mustang"));
        cars.add(new Car("1967", "AZ54321", "Charger"));

        List<Car> filteredCars = cars.stream()
                .filter(car -> car.getMakeYear().startsWith("196"))
                .filter(car -> car.getLicensePlate().startsWith("AZ"))
                .sorted(Comparator.comparing(Car::getModelName))
                .collect(Collectors.toList());

        // Print the filtered and sorted list
        filteredCars.forEach(car ->
                System.out.println(car.getModelName() + " " + car.getMakeYear() + " " + car.getLicensePlate()));
    }
}