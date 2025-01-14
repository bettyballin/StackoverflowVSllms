import java.lang.String;

public class Main {

    // Example Engine class for demonstration purposes
    class Engine {
        private final String type;

        public Engine(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Engine)) return false;
            Engine engine = (Engine) o;
            return type != null ? type.equals(engine.type) : engine.type == null;
        }

        @Override
        public int hashCode() {
            return type != null ? type.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "type='" + type + '\'' +
                    '}';
        }
    }

    interface Vehicle {
        Engine getEngine();
    }

    class Car implements Vehicle {
        private final Engine engine;

        public Car(Engine engine) {
            this.engine = engine;
        }

        @Override
        public Engine getEngine() {
            return engine;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Car)) return false;

            Car car = (Car) o;

            return engine != null ? engine.equals(car.engine) : car.engine == null;
        }

        @Override
        public int hashCode() {
            return engine != null ? engine.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "engine=" + engine +
                    '}';
        }
    }

    public static void main(String[] args) {
    }
}