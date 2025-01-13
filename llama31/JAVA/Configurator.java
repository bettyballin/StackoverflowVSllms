public class Configurator {
    boolean debugMode = true; // or false

    public Configurator() {
        if (!debugMode) {
            // Do something()
        }
    }

    public static void main(String[] args) {
        new Configurator();
    }
}