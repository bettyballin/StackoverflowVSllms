import java.util.ArrayList;
import java.util.Objects;

public class YourClassUtils {
    public boolean containsByFields(ArrayList<YourObjectType> list, Object field1Value, Object field2Value) {
        for (YourObjectType obj : list) {
            if (Objects.equals(obj.getField1(), field1Value) && Objects.equals(obj.getField2(), field2Value)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
    }
}

class YourObjectType {
    public Object getField1() {
        return null;
    }
    public Object getField2() {
        return null;
    }
}