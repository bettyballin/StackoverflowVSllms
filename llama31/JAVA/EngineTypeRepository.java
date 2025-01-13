import java.util.Map;
import java.util.HashMap;

class EngineType {
    private String referenceKey;
    private String name;
    private int maxRPM;

    public EngineType(String referenceKey, String name, int maxRPM) {
        this.referenceKey = referenceKey;
        this.name = name;
        this.maxRPM = maxRPM;
    }

    public String getReferenceKey() {
        return referenceKey;
    }

    public String getName() {
        return name;
    }

    public int getMaxRPM() {
        return maxRPM;
    }
}

class EngineTypeRepository {
    private static EngineTypeRepository instance;
    private Map<String, EngineType> engineTypes = new HashMap<>();

    private EngineTypeRepository() {}

    public static EngineTypeRepository getInstance() {
        if (instance == null) {
            instance = new EngineTypeRepository();
        }
        return instance;
    }

    public EngineType getEngineType(String referenceKey) {
        return engineTypes.get(referenceKey);
    }

    public void registerEngineType(EngineType engineType) {
        engineTypes.put(engineType.getReferenceKey(), engineType);
    }
}

public class Car {
    private String name;
    private String engineTypeReferenceKey;

    public Car(String name, String engineTypeReferenceKey) {
        this.name = name;
        this.engineTypeReferenceKey = engineTypeReferenceKey;
    }

    public String getDescription() {
        EngineType engineType = EngineTypeRepository.getInstance().getEngineType(engineTypeReferenceKey);
        return "I am a car called " + name + ", whose " + engineType.getName() + " engine can run at " + engineType.getMaxRPM() + " RPM!";
    }

    public static void main(String[] args) {
        EngineType engineType = new EngineType("V8", "V8 Engine", 6000);
        EngineTypeRepository.getInstance().registerEngineType(engineType);

        Car car = new Car("Mustang", "V8");
        System.out.println(car.getDescription());
    }
}