/*
 * Decompiled with CFR 0.152.
 */
package app;

import java.io.Console;

public class MainClass {
    public static void main(String[] stringArray) {
        Console console = System.console();
        if (console != null) {
            console.printf("Hello, world!!", new Object[0]);
        } else {
            System.out.println("No console available");
        }
    }
}
