/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlScriptRecorder {
    public static void recordSqlStatement(String string) throws IOException {
        FileWriter fileWriter = new FileWriter("sql_script.sql", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(string + ";");
        printWriter.close();
    }

    public static void executeSqlScript(Connection connection, File file) throws SQLException, IOException {
        String string;
        Statement statement = connection.createStatement();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while ((string = bufferedReader.readLine()) != null) {
            statement.execute(string);
        }
        statement.close();
        bufferedReader.close();
    }

    public static void main(String[] stringArray) {
    }
}
