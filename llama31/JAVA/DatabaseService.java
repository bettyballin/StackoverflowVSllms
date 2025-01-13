import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void writeRow(DatabaseRequest databaseRequest) {
        jdbcTemplate.update("INSERT INTO my_table (column1, column2) VALUES (?, ?)", databaseRequest.getColumn1(), databaseRequest.getColumn2());
    }

	public static void main(String[] args) {
	}
}

class DatabaseRequest {
    private String column1;
    private String column2;

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }
}