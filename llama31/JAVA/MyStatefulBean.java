import javax.ejb.Stateful;

@Stateful
public class MyStatefulBean {
    private int counter;

    public synchronized void incrementCounter() {
        counter++;
    }

    public synchronized int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        // Create an instance of the stateful bean
        MyStatefulBean bean = new MyStatefulBean();

        // Increment the counter
        bean.incrementCounter();

        // Get the current counter value
        int currentValue = bean.getCounter();

        // Print the current counter value
        System.out.println("Current counter value: " + currentValue);
    }
}