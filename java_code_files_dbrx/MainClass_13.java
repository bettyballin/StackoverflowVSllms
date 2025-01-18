import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.HibernateException;
import java.sql.SQLSyntaxErrorException;

public class MainClass {
    public static void main(String[] args) {
        try {
            // Perform your Hibernate operations here
        } catch(ConstraintViolationException e) {
            if (e.getCause() instanceof SQLSyntaxErrorException) {
                SQLSyntaxErrorException exception = (SQLSyntaxErrorException) e.getCause();
                String message = exception.getMessage();

                // For MySQL, error messages contain the table name and constraint column like:
                // "Duplicate entry '1' for key 'your_table.unique_key'" or "PK" instead of "UNIQUE"
                if (message != null && message.contains("for key")) {
                    int colonIndex = message.lastIndexOf("`"); // Find the last occurrence of ` to get the constraint name
                    String tableAndConstraintName = message.substring(colonIndex - 4, colonIndex); // Cut off " for key " (5 characters) from end of String
                    String[] tokens = tableAndConstraintName.split("\\."); // Split into table and column part on .

                    System.out.println("Table Name: " + tokens[0]);
                    System.out.println("Column: " + tokens[1].replaceAll("[^a-z_]",""));  // Replace anything except letters or _ with nothing to get the name of constraint, can be used to fetch the column details further if needed.
                } else {
                    System.out.println("Unable to parse SQL exception message.");
                }
            }
        } catch (HibernateException e) {
            // Handle other Hibernate exceptions here if you have any specific logic for those
        }
    }
}