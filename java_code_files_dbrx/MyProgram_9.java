public class MyProgram {
    public static void main(String[] args) {
        Counter counter = Metrics.counter("my_counter", "tag1", "value1");   // define a meter
        counter.increment();  // update the value for 'my_counter'
    }
}

// Minimal implementation of Counter
class Counter {
    private double count = 0;

    public void increment() {
        count++;
        System.out.println("Counter incremented. Current value: " + count);
    }
}

// Minimal implementation of Metrics
class Metrics {
    public static Counter counter(String name, String tagKey, String tagValue) {
        System.out.println("Creating counter with name: " + name + ", " + tagKey + "=" + tagValue);
        return new Counter();
    }
}