/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CarSorter {
    public static void sortCars(Car[] carArray) {
        Collections.sort(Arrays.asList(carArray), Comparator.comparing(Car::getModel));
    }

    public static void main(String[] stringArray) {
        SecureRandom secureRandom = new SecureRandom();
        Car[] carArray = new Car[10];
        for (int i = 0; i < 10; ++i) {
            Car car = new Car();
            car.setModel("Model " + secureRandom.nextInt(100));
            carArray[i] = car;
        }
        CarSorter.sortCars(carArray);
        for (Car car : carArray) {
            System.out.println(car.getModel());
        }
    }
}
