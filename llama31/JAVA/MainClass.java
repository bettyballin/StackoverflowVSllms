package app;

import java.io.Console;

public class MainClass {

    public static void main(String[] args) {
        Console console = System.console();
        if (console != null) {
            console.printf("Hello, world!!");
        } else {
            System.out.println("No console available");
        }
    }
}