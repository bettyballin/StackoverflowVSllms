import java.sql.Types;

// Assuming EnumType is a custom class, you might need to import it
// import your.package.EnumType;

// Assuming DealType is an enum, you might need to import it
// import your.package.DealType;

public class DealTypeEnumType extends EnumType<DealType> {
    public DealTypeEnumType() {
        super(DealType.class, "id");
    }

    @Override
    public Class<DealType> returnedClass() {
        return DealType.class;
    }

    @Override
    public DealType fromString(String string) {
        return DealType.valueOf(string);
    }

    @Override
    public String toString(DealType value) {
        return value.name();
    }

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.INTEGER};
    }

    public static void main(String[] args) {
    }
}