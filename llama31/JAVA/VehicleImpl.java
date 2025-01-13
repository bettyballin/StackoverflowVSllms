// Define the Engine class for demonstration purposes
class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Engine engine = (Engine) obj;
        return type.equals(engine.type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        return "Engine{" +
                "type='" + type + '\'' +
                '}';
    }
}

// Define the Vehicle interface
interface Vehicle {
    Engine getEngine();
}

public class VehicleImpl implements Vehicle {
    private final Engine engine;

    public VehicleImpl(Engine engine) {
        this.engine = engine;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        VehicleImpl vehicle = (VehicleImpl) obj;
        return engine.equals(vehicle.engine);
    }

    @Override
    public int hashCode() {
        return engine.hashCode();
    }

    @Override
    public String toString() {
        return "VehicleImpl{" +
                "engine=" + engine +
                '}';
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine("V8");
        VehicleImpl myVehicle = new VehicleImpl(myEngine);
        System.out.println(myVehicle.toString());
    }
}