import java.io.*;

public class LearningAlgorithm implements Serializable {
    // algorithm state variables...

    public void saveToFile(String filename) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(this);
        oos.close();
    }

    public static LearningAlgorithm loadFromFile(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        LearningAlgorithm algorithm = (LearningAlgorithm) ois.readObject();
        ois.close();
        return algorithm;
    }

	public static void main(String[] args) {
	}
}