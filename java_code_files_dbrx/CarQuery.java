import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarQuery {

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>(); // assume this list is populated...
        // Sample data
        cars.add(new Car(1965, "AZ1234", "Mustang"));
        cars.add(new Car(1967, "CA5678", "Camaro"));
        cars.add(new Car(1962, "AZ9876", "Corvette"));
        cars.add(new Car(1970, "AZ1111", "Charger"));
        cars.add(new Car(1968, "AZ2222", "Firebird"));

        Query<Car> query = QueryBuilder.<Car>select().from(cars)
          .where(c -> c.getManufactureDate() >= 1960 && c.getManufactureDate() <= 1969)
          .and(c -> c.getLicensePlate().startsWith("AZ"))
          .orderByField("modelName")
          .build();
        List<Car> results = query.execute();

        // Output the results
        for (Car car : results) {
            System.out.println(car.getModelName() + " - " + car.getLicensePlate() + " - " + car.getManufactureDate());
        }
    }
}

class Car {
    private int manufactureDate;
    private String licensePlate;
    private String modelName;

    public Car(int manufactureDate, String licensePlate, String modelName) {
        this.manufactureDate = manufactureDate;
        this.licensePlate = licensePlate;
        this.modelName = modelName;
    }

    public int getManufactureDate() {
        return manufactureDate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModelName() {
        return modelName;
    }
}

class QueryBuilder<T> {
    private List<T> source;
    private Predicate<T> predicate;
    private Comparator<T> comparator;

    public static <T> QueryBuilder<T> select() {
        return new QueryBuilder<>();
    }

    public QueryBuilder<T> from(List<T> source) {
        this.source = source;
        return this;
    }

    public QueryBuilder<T> where(Predicate<T> predicate) {
        this.predicate = predicate;
        return this;
    }

    public QueryBuilder<T> and(Predicate<T> otherPredicate) {
        this.predicate = this.predicate != null ? this.predicate.and(otherPredicate) : otherPredicate;
        return this;
    }

    public QueryBuilder<T> orderByField(String fieldName) {
        // For simplicity, let's use reflection to get the field value
        Comparator<T> comparator = (o1, o2) -> {
            try {
                Object value1 = o1.getClass().getMethod("get" + capitalize(fieldName)).invoke(o1);
                Object value2 = o2.getClass().getMethod("get" + capitalize(fieldName)).invoke(o2);
                @SuppressWarnings("unchecked")
                Comparable<Object> comp1 = (Comparable<Object>) value1;
                return comp1.compareTo(value2);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        this.comparator = comparator;
        return this;
    }

    public Query<T> build() {
        return new Query<>(source, predicate, comparator);
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}

class Query<T> {
    private final List<T> source;
    private final Predicate<T> predicate;
    private final Comparator<T> comparator;

    public Query(List<T> source, Predicate<T> predicate, Comparator<T> comparator) {
        this.source = source;
        this.predicate = predicate;
        this.comparator = comparator;
    }

    public List<T> execute() {
        Stream<T> stream = source.stream();
        if (predicate != null) {
            stream = stream.filter(predicate);
        }
        if (comparator != null) {
            stream = stream.sorted(comparator);
        }
        return stream.collect(Collectors.toList());
    }
}