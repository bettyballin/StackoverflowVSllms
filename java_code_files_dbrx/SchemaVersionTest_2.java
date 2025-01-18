import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import javax.sql.DataSource;

public class SchemaVersionTest_2 {
    private DataSource dataSource;
    private String expectedSchemaVersion;

    @Test
    public void checkMigration() {
        Flyway flyway = new Flyway();
        flyway.setBaselineVersionAsString("1");
        flyway.setDataSource(dataSource);
        MigrationInfo info = flyway.info().current();
        assertEquals(expectedSchemaVersion, info.getVersionNumber());
    }

    public static void main(String[] args) {
    }
}