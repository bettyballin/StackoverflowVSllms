import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.rowset.serial.SerialClob;

public class InsertStatementCreator {

    Connection con;
    String myLongString;

    {
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO SomeTable(text) VALUES (?)");
            pstmt.setClob(1, new SerialClob(myLongString));
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}