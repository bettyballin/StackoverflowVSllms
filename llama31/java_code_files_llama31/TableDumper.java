/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TableDumper {
    public static void dumpTable(Connection connection, String string, File file) throws SQLException, IOException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + string);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));){
            int n;
            for (n = 1; n <= resultSetMetaData.getColumnCount(); ++n) {
                bufferedWriter.write(resultSetMetaData.getColumnName(n));
                if (n >= resultSetMetaData.getColumnCount()) continue;
                bufferedWriter.write(",");
            }
            bufferedWriter.newLine();
            while (resultSet.next()) {
                for (n = 1; n <= resultSetMetaData.getColumnCount(); ++n) {
                    bufferedWriter.write(resultSet.getString(n));
                    if (n >= resultSetMetaData.getColumnCount()) continue;
                    bufferedWriter.write(",");
                }
                bufferedWriter.newLine();
            }
        }
    }

    public static void hydrateTable(Connection connection, String string, File file) throws SQLException, IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));){
            String string2;
            CharSequence[] charSequenceArray = bufferedReader.readLine().split(",");
            String string3 = "INSERT INTO " + string + " (" + String.join((CharSequence)",", charSequenceArray) + ") VALUES (" + String.join((CharSequence)",", new String[charSequenceArray.length]).replace("null", "?") + ")";
            PreparedStatement preparedStatement = connection.prepareStatement(string3);
            while ((string2 = bufferedReader.readLine()) != null) {
                String[] stringArray = string2.split(",");
                for (int i = 0; i < stringArray.length; ++i) {
                    preparedStatement.setString(i + 1, stringArray[i]);
                }
                preparedStatement.executeUpdate();
            }
        }
    }

    public static void main(String[] stringArray) {
    }
}
