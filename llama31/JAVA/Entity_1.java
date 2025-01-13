import javax.persistence.Convert;

public class Entity_1_1 {
    @Convert(converter = EmptyStringToNullConverter.class)
    private String myField;

    public static void main(String[] args) {
    }
}