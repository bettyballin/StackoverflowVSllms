import java.util.List;

public class CurrentConditionsDisplay {
    // Example: Weather station notifying subscribers of changes

    interface Observer {
        void update();
    }

    class CurrentConditionsDisplay implements Observer {
        @Override
        public void update() {
            // Empty implementation
        }
    }

    class WeatherData {
        List<Observer> observers;

        public void notifyObservers() {
            // Empty implementation
        }
    }

    public static void main(String[] args) {
    }
}