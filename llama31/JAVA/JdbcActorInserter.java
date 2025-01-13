import java.lang.String;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcActorInserter {
    private SimpleJdbcInsert insertActor;
    private DataSource dataSource;

    public JdbcActorInserter() {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test", "sa", "");
        insertActor = new SimpleJdbcInsert(dataSource)
                .withTableName("tbl")
                .usingGeneratedKeyColumns("id");
    }

    public void insert() {
        Number newId = insertActor.executeAndReturnKey(new MapSqlParameterSource("data", "something"));
        System.out.println(newId);
    }

    public static void main(String[] args) {
        JdbcActorInserter jdbcActorInserter = new JdbcActorInserter();
        jdbcActorInserter.insert();
    }
}