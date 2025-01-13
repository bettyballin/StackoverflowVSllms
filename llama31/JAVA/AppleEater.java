import java.util.Scanner;

enum ValueState {
    UNKNOWN,
    NULL,
    KNOWN
}

class Value<T> {
    private T value;
    private ValueState state;

    public Value(T value, ValueState state) {
        this.value = value;
        this.state = state;
    }

    public T getValue() {
        return value;
    }

    public ValueState getState() {
        return state;
    }

    public void setState(ValueState state) {
        this.state = state;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

public class AppleEater {

    private Value<String> apple;
    private Scanner scanner;

    public AppleEater() {
        apple = new Value<>("", ValueState.UNKNOWN);
        scanner = new Scanner(System.in);
    }

    public void askForApple() {
        System.out.println("Do you have an apple? (yes/no)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            System.out.println("What's the apple's name?");
            String appleName = scanner.nextLine();
            apple.setValue(appleName);
            apple.setState(ValueState.KNOWN);
        } else if (input.equalsIgnoreCase("no")) {
            apple.setState(ValueState.NULL);
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public void sulk() {
        System.out.println("I'm sulking because I didn't get an apple.");
    }

    public void eatApple(String appleName) {
        System.out.println("I'm eating the " + appleName + " apple.");
    }

    public void run() {
        while (apple.getState() == ValueState.UNKNOWN) {
            askForApple();
        }

        if (apple.getState() == ValueState.NULL) {
            sulk();
        } else {
            eatApple(apple.getValue());
        }
    }

    public static void main(String[] args) {
        AppleEater appleEater = new AppleEater();
        appleEater.run();
    }
}