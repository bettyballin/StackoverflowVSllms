import java.lang.String;

public class Entity_2_2 {
    private long id;
    private String name;

    @Override
    public int hashCode() {
        int result = 17; // initial value
        result = 31 * result + (int) (id ^ (id >>> 32)); // assuming 'id' is a long field
        result = 31 * result + (name != null ? name.hashCode() : 0); // assuming 'name' is a String field
        return result;
    }

    public static void main(String[] args) {
    }
}