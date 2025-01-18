public abstract class AbstractEngine {
    private Engine engine; // assume Engine is a third party library or something you have no control over its interface

    protected abstract void initEngine(Engine engine);

    public AbstractEngine() { // this allows a uniform creation process, e.g., constructor injection using some Dependency Injection framework like Spring in Java or Unity in .NET
        Engine engine = new Engine();
        this.engine = engine;
        this.initEngine(engine);
    }

    public static void main(String[] args) {
    }
}

class Engine {
    // Assume Engine is a third-party class; we can leave it empty
}