import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleMetaData;
import oracle.jdbc.OracleType;
import oracle.jdbc.OracleTypeADT;
import oracle.sql.Struct;
import oracle.sql.ORADataFactory;
import oracle.sql.ORADataFactoryImpl;

public class ArrayDataFactory {

    public static void main(String[] args) {
        try {
            // Assuming you have a Connection object 'conn'
            Connection conn = null; // You need to initialize your connection

            // Prepare statement and execute query
            PreparedStatement wordStmt = conn.prepareStatement("select distinct word from table");
            ResultSet wordsRs = wordStmt.executeQuery();

            // Fetch the words into a list
            List<String> filteredWords = new ArrayList<>();
            while (wordsRs.next()) {
                filteredWords.add(wordsRs.getString(1));
            }

            // Create an OracleArray to be used with the query below
            OracleConnection oraConn = conn.unwrap(OracleConnection.class);
            Struct[] structs = new Struct[filteredWords.size()];
            for (int i = 0; i < structs.length; ++i) {
                Object[] array = filteredWords.subList(i, i + 1).toArray(); // Each Struct holds one element of words list
                ORADataFactory factory = ORADataFactoryImpl.getORADataFactory("WORD_ARRAY");
                structs[i] = factory.create(array);
            }
            OracleMetaData md = (OracleMetaData) oraConn.getMetaData();
            OracleType OTYPE = OracleTypeADT.newOracleType("WORD_ARRAY", oraConn, md);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}