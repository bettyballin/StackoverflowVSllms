import java.lang.String;
import java.io.*;
import java.util.*;
class MyModel implements Serializable {/* your model code here */}
public class MainClass_18 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Save the trained model to a file
        FileOutputStream fos = new FileOutputStream("mymodel.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        MyModel model= new MyModel();// Assuming you've got a trained model here
        oos.writeObject(model);
        oos.close();

        // Load the saved model from file
        FileInputStream fis = new FileInputStream("mymodel.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        MyModel loadedModel= (MyModel)ois.readObject();
        ois.close();
    }
}