import java.lang.String;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ConsoleInputExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.print("Enter command: ");
        // create process to run 'stty -echo' for hiding typed input (Linux only)
        ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", "stty -echo");
        pb.inheritIO();
        pb.start().waitFor(50, TimeUnit.MILLISECONDS); // waiting a bit for the command to execute
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // create process to run 'stty echo' for returning normal behavior of console (Linux only)
        pb = new ProcessBuilder("/bin/bash", "-c", "stty echo");
        pb.inheritIO().start();
        System.out.println("Output goes here");
    }
}