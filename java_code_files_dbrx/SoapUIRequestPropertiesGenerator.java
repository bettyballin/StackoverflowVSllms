public class SoapUIRequestPropertiesGenerator {

    // Define the RequestProperties class
    public class RequestProperties {
        public void setProperty(String key, String value) {
            // Implementation here
        }
    }

    // Define the Properties class
    public class Properties {
        public void set(RequestProperties properties) {
            // Implementation here
        }
    }

    // Define the RequestStep class
    public class RequestStep {
        public Properties getProperties() {
            return new Properties();
        }
    }

    // Instance variables
    RequestProperties properties = new RequestProperties();
    RequestStep requestStep = new RequestStep();

    // Instance initializer block
    {
        // This code will automatically generate in backend
        properties.setProperty("Save Messages", "True"); // or use 'true' based on SoapUI version
        requestStep.getProperties().set(properties);
    }

    public static void main(String[] args) {
        // Create an instance to execute the instance initializer block
        new SoapUIRequestPropertiesGenerator();
    }
}