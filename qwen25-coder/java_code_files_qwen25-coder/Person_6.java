import java.lang.String;
public class Person_6 {
    private final int personId;
    private OtherClass otherClassInstance = null;

    public Person_6(int personId) {
        this.personId = personId;
    }

    public OtherClass getOtherClass() {
        if (otherClassInstance == null) {
            otherClassInstance = new OtherClass(personId);
        }
        return otherClassInstance;
    }
}

class OtherClass {
    public OtherClass(int personId) {
        // Initialize with personId
    }

    public static void main(String[] args) {
    }
}