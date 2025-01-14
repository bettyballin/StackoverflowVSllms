interface Engine {
    void start();
}

class CarEngine implements Engine {
    private String type;

    public CarEngine(String type) {
        this.type = type;
    }

    @Override
    public void start() {
        System.out.println("Car engine of type " + type + " started.");
    }
}

interface EngineFactory {
    Engine createEngine(String type);
}

public class CarEngineFactory implements EngineFactory {
    @Override
    public Engine createEngine(String type) {
        return new CarEngine(type);
    }

    public static void main(String[] args) {
        EngineFactory factory = new CarEngineFactory();
        Engine engine = factory.createEngine("V8");
        engine.start();
    }
}