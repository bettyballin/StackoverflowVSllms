/*
 * Decompiled with CFR 0.152.
 */
import java.util.Scanner;

public class AppleEater {
    private Value<String> apple = new Value<String>("", ValueState.UNKNOWN);
    private Scanner scanner = new Scanner(System.in);

    public void askForApple() {
        System.out.println("Do you have an apple? (yes/no)");
        String string = this.scanner.nextLine();
        if (string.equalsIgnoreCase("yes")) {
            System.out.println("What's the apple's name?");
            String string2 = this.scanner.nextLine();
            this.apple.setValue(string2);
            this.apple.setState(ValueState.KNOWN);
        } else if (string.equalsIgnoreCase("no")) {
            this.apple.setState(ValueState.NULL);
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public void sulk() {
        System.out.println("I'm sulking because I didn't get an apple.");
    }

    public void eatApple(String string) {
        System.out.println("I'm eating the " + string + " apple.");
    }

    public void run() {
        while (this.apple.getState() == ValueState.UNKNOWN) {
            this.askForApple();
        }
        if (this.apple.getState() == ValueState.NULL) {
            this.sulk();
        } else {
            this.eatApple(this.apple.getValue());
        }
    }

    public static void main(String[] stringArray) {
        AppleEater appleEater = new AppleEater();
        appleEater.run();
    }
}
