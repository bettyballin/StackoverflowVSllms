import org.springframework.jdbc.core.JdbcTemplate;

public class SequenceGeneratorImpl {

    private JdbcTemplate jdbcTemplate;

    // execute using Spring DataJPA Repository or JDBC Template
    public SequenceGeneratorImpl() {
        Long id = jdbcTemplate.queryForObject("SELECT last_value FROM your_sequance", Long.class);
        System.out.println(id);
    }

    public static void main(String[] args) {
        new SequenceGeneratorImpl();
    }
}