import java.sql.*;
import java.io.*;

public class MyScriptRunner {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql:///x", "x", "x"); // replace with your own DB credentials and host details
        QueryRunner queryRunner = new QueryRunner();
        ScriptRunner scriptRunner = new ScriptRunner(connection, false, false);
        Reader reader = new BufferedReader(new FileReader("your_script.sql"));
        scriptRunner.runScript(reader);
    }
}

class QueryRunner {
    // Empty implementation for compilation
}

class ScriptRunner {
    private Connection connection;
    private boolean stopOnError;
    private boolean autoCommit;

    public ScriptRunner(Connection connection, boolean autoCommit, boolean stopOnError) {
        this.connection = connection;
        this.autoCommit = autoCommit;
        this.stopOnError = stopOnError;
    }

    public void runScript(Reader reader) throws SQLException, IOException {
        StringBuilder command = null;
        try {
            LineNumberReader lineReader = new LineNumberReader(reader);
            String line = null;
            command = new StringBuilder();
            while ((line = lineReader.readLine()) != null) {
                // Ignore comments and empty lines
                if (line.startsWith("--") || line.trim().length() < 1) {
                    continue;
                }
                // Remove SQL statement delimiter at the end of the line
                if (line.trim().endsWith(";")) {
                    line = line.substring(0, line.lastIndexOf(";"));
                }
                command.append(line).append(" ");
                // Check if the command is complete (ends with a semicolon)
                if (line.trim().endsWith(";")) {
                    Statement stmt = connection.createStatement();
                    try {
                        stmt.execute(command.toString());
                    } catch (SQLException e) {
                        e.fillInStackTrace();
                        System.err.println("Error executing: " + command);
                        System.err.println(e);
                        if (stopOnError) {
                            throw e;
                        }
                    }
                    command = new StringBuilder();
                }
            }
            if (!autoCommit) {
                connection.commit();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error running script. Cause: " + e, e);
        }
    }
}