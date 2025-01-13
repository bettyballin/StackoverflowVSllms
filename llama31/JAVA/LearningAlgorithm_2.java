import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class LearningAlgorithm_2_2 {
    // algorithm state variables...

    public void saveToFile(String filename) throws IOException {
        Properties props = new Properties();
        props.setProperty("state_variable_1", "value_1");
        props.setProperty("state_variable_2", "value_2");
        props.store(new FileOutputStream(filename), null);
    }

    public static LearningAlgorithm_2 loadFromFile(String filename) throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(filename));
        // reconstruct algorithm state from properties...
        LearningAlgorithm_2 algorithm = new LearningAlgorithm_2();
        // Assign the reconstructed state to the algorithm object...
        return algorithm;
    }

    public static void main(String[] args) {
    }
}