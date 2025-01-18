import java.lang.String;
import java.io.*;
public class ConsoleTest_1 {
    public static void main(String[] args) throws IOException {
        Console cons = System.console();
        if (cons == null) {
            throw new IllegalStateException("Console not available.");
        }

        String username;
        char[] password;

        username = cons.readLine("%s", "Enter your username: ");
        password = cons.readPassword("%s", "Enter your password: ");

        // print username and password
        System.out.printf("Username entered is %s%n",username);
        System.out.print("Password entered is");
        for(int i=0;i<password.length;i++){
            System.out.print("*");
        }
        System.out.println();
    }
}