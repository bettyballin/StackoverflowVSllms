import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;
import java.net.URI;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.File;
import java.util.Properties;
import java.io.StringReader;

public class MyClass {

    public static void setLoggingConfig(String loggingProperties) {
        try (final InputStream propFile = new ByteArrayInputStream(loggingProperties.getBytes(StandardCharsets.UTF_8))) {
            final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
            final Configuration config = ctx.getConfiguration();
            if (!(config instanceof DefaultConfiguration)) {
                return; // ignore the case when configuration is already initialized by different Factory
            }
            String log4j2Properties = "log4j2.properties";
            URI uri = new File(".").toURI().resolve(log4j2Properties);
            final ConfigurationSource configSource = new ConfigurationSource(propFile, uri);

            // Load properties from loggingProperties string
            Properties properties = new Properties();
            properties.load(new StringReader(loggingProperties));

            final Configuration newConfig = new PropertiesConfiguration.Builder()
                    .setConfigurationSource(configSource)
                    .setProperties(properties)
                    .setLoggerContext(ctx)
                    .build();
            ctx.start(newConfig);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to load default logging properties", e);
        }
    }

}