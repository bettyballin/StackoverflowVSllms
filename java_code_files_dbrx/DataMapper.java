import java.lang.String;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataMapper {
    private static final class DataMapper implements RowMapper<Object> {

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            // your row mapping implementation goes here
            return null;
        }
    }

    public static void main(String[] args) {
        // main method implementation
    }
}

interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws SQLException;
}