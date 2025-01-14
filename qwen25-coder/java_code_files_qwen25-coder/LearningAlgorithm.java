import java.lang.String;
import java.io.*;

class Model implements Serializable {
    private static final long serialVersionUID = 1L;
    public double[] parameters;

    // Constructor
    public Model(double[] parameters) {
        this.parameters = parameters;
    }
}

public class LearningAlgorithm {

    // Save the model to a file
    public void saveModel(Model model, String filename) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(model);
        }
    }

    // Load the model from a file
    public Model loadModel(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Model) ois.readObject();
        }
    }

    public static void main(String[] args) {
        LearningAlgorithm la = new LearningAlgorithm();
        Model model = new Model(new double[]{0.1, 0.2, 0.3});

        try {
            // Save the model
            la.saveModel(model, "model.ser");

            // Load the model
            Model loadedModel = la.loadModel("model.ser");
            System.out.println(java.util.Arrays.toString(loadedModel.parameters));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}