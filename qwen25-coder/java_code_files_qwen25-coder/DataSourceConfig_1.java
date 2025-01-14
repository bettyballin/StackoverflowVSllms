import java.lang.String;

@interface Configuration { }
@interface Bean {
    String name();
}
@interface Profile {
    String value();
}

class EmbeddedDatabase { }

class EmbeddedDatabaseBuilder {
    public EmbeddedDatabaseBuilder setType(EmbeddedDatabaseType type) {
        return this;
    }

    public EmbeddedDatabaseBuilder setName(String name) {
        return this;
    }

    public EmbeddedDatabaseBuilder addScript(String script) {
        return this;
    }

    public EmbeddedDatabase build() {
        return new EmbeddedDatabase();
    }
}

enum EmbeddedDatabaseType {
    H2, DERBY, HSQL
}

interface DataSource { }

@Configuration
public class DataSourceConfig_1 {

    @Bean(name = "dataSource")
    @Profile("test")
    public EmbeddedDatabase dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .setName("testDataSource")
            .addScript("classpath:test.sql") // Bootstrap script
            .build();
    }

    @Bean(name = "dataSource")
    @Profile("!test")
    public DataSource productionDataSource() {
        // Configuration for real database
        return null;
    }

    public static void main(String[] args) {
    }
}