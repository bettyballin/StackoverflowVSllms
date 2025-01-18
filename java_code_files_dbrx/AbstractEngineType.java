import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlyweightExample {

    // Flyweight Object
    public abstract class AbstractEngineType {
        private final String name;
        protected AbstractEngineType(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "AbstractEngineType{name='" + name + "'}";
        }
        // More shared parts here...
    }

    public class WankelEngine extends AbstractEngineType {
        public WankelEngine(String name) {
            super(name);
        }
        // Implement any abstract methods if needed
    }

    class EngineBroker {
        private static Map<String, AbstractEngineType> engines = new ConcurrentHashMap<>();

        public synchronized AbstractEngineType getEngine(String engineName) {
            if (engines.get(engineName) == null) {
                // Create a WankelEngine or any other specific Engine here and put into the map
                engines.put(engineName, new WankelEngine(engineName));
            }
            return engines.get(engineName);
        }
    }

    // Client Object:
    class Car {
        public String name;
        private AbstractEngineType abstractType;

        public Car(String carName, String engineName) {
            this.name = carName;
            // Broker is used here...
            EngineBroker broker = new EngineBroker();
            abstractType = broker.getEngine(engineName);
        }

        // Getter for abstractType
        public AbstractEngineType getAbstractType() {
            return abstractType;
        }
        // Other methods and instance variables...
    }

    public static void main(String[] args) {
        // For testing purposes, let's create some cars.
        FlyweightExample example = new FlyweightExample();
        Car car1 = example.new Car("CarA", "Wankel");
        Car car2 = example.new Car("CarB", "Wankel");

        // Now car1 and car2 share the same engine instance (if they have the same engineName)
        // We can add some print statements to check.
        System.out.println("Car1 engine: " + car1.getAbstractType());
        System.out.println("Car2 engine: " + car2.getAbstractType());
        System.out.println("Same engine instance: " + (car1.getAbstractType() == car2.getAbstractType()));
    }
}