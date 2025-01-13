/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class LearningAlgorithm
implements Serializable {
    public void saveToFile(String string) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(string));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    public static LearningAlgorithm loadFromFile(String string) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(string));
        LearningAlgorithm learningAlgorithm = (LearningAlgorithm)objectInputStream.readObject();
        objectInputStream.close();
        return learningAlgorithm;
    }

    public static void main(String[] stringArray) {
    }
}
