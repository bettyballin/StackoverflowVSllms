import java.util.ArrayList;
import java.util.Objects;

class ObjectWithFields {
    int field1, field2, unimportantField1, unimportantField2;

    public ObjectWithFields(int f1, int f2) {
        this.field1 = f1;
        this.field2 = f2;
    }
}

public class Main_44 {

    static boolean containsObject(ArrayList<ObjectWithFields> list, int field1, int field2) {
        for (ObjectWithFields obj : list) {
            if (Objects.equals(obj.field1, field1) && Objects.equals(obj.field2, field2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}