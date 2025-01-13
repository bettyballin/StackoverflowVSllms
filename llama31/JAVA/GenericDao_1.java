import java.io.Serializable;

// Define the Identifiable interface
interface Identifiable<PK> {
    PK getId();
}

// Define the GenericDao interface
interface GenericDao<T extends Identifiable<PK>, PK extends Serializable> {
    T findById(PK id);
}

// Main class
public class GenericDao_1_1 {
    public static void main(String[] args) {
    }
}