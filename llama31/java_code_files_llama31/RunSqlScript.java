/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RunSqlScript {
    public static void main(String[] stringArray) {
        String string = "jdbc:mysql:///x";
        String string2 = "x";
        String string3 = "x";
        String string4 = "/path/to/script.sql";
        try (Connection connection = DriverManager.getConnection(string, string2, string3);
             Statement statement = connection.createStatement();){
            File file = new File(string4);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String string5 = scanner.nextLine();
                if (string5.trim().isEmpty()) continue;
                statement.execute(string5);
            }
            scanner.close();
        }
        catch (FileNotFoundException | SQLException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
